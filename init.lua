-- ─────────────────────────────────────────────────────────────
-- SETUP BASE46 (NVCHAD THEME CACHE)
-- ─────────────────────────────────────────────────────────────
vim.g.base46_cache = vim.fn.stdpath("data") .. "/base46/"

-- leader key
vim.g.mapleader = " "

-- ─────────────────────────────────────────────────────────────
-- BOOTSTRAP LAZY.NVIM (PLUGIN MANAGER)
-- ─────────────────────────────────────────────────────────────
local lazypath = vim.fn.stdpath("data") .. "/lazy/lazy.nvim"

if not vim.uv.fs_stat(lazypath) then
  local repo = "https://github.com/folke/lazy.nvim.git"
  vim.fn.system({ "git", "clone", "--filter=blob:none", repo, "--branch=stable", lazypath })
end

vim.opt.rtp:prepend(lazypath)

-- ─────────────────────────────────────────────────────────────
-- LAZY CONFIG
-- ─────────────────────────────────────────────────────────────
local lazy_config = require("configs.lazy")

-- ─────────────────────────────────────────────────────────────
-- PLUGINS
-- ─────────────────────────────────────────────────────────────
require("lazy").setup({
  -- NvChad core
  { "neovim/nvim-lspconfig" },
  -- Autocomplete
  {
    "hrsh7th/nvim-cmp",
    dependencies = {
      "hrsh7th/cmp-nvim-lsp",
      "L3MON4D3/LuaSnip",
      "saadparwaiz1/cmp_luasnip",
    },
  },
  -- Syntax highlighting
  { "nvim-treesitter/nvim-treesitter", build = ":TSUpdate" },
  {
    "NvChad/NvChad",
    lazy = false,
    branch = "v2.5",
    import = "nvchad.plugins",
  },
  -- Additional plugins (import from your lua/plugins folder)
  { import = "plugins" },

  -- Telescope plugin
  {
    "nvim-telescope/telescope.nvim",
    dependencies = { "nvim-lua/plenary.nvim" },
    config = function()
      require("telescope").setup({})
    end,
  },

  -- NvCheatsheet
  {
    "smartinellimarco/nvcheatsheet.nvim",
    config = function()
      require("nvcheatsheet").setup({})
    end,
  },
}, lazy_config)

-- ─────────────────────────────────────────────────────────────
-- LOAD THEME
-- ─────────────────────────────────────────────────────────────
dofile(vim.g.base46_cache .. "defaults")
dofile(vim.g.base46_cache .. "statusline")

-- ─────────────────────────────────────────────────────────────
-- OPTIONS & AUTOCMDS
-- ─────────────────────────────────────────────────────────────
require("options")
require("autocmds")

-- ─────────────────────────────────────────────────────────────
-- MAPPINGS (delay to avoid race condition)
-- ─────────────────────────────────────────────────────────────
vim.schedule(function()
  require("mappings")
end)

-- ─────────────────────────────────────────────────────────────
-- DSA JAVA KEYMAPS (loaded post-plugins for reliability)
-- ─────────────────────────────────────────────────────────────
-- Define output buffer name globally
local output_buf_name = "JavaOutput"

-- Utility function to clean Windows CR (\r) characters from output lines
local function clean_lines(lines)
  local cleaned = {}
  for _, line in ipairs(lines) do
    line = line:gsub("\r", "") -- Remove trailing carriage returns
    table.insert(cleaned, line)
  end
  return cleaned
end

-- DSA Templates (<leader>j*)
vim.keymap.set("n", "<leader>jl", function()
  local lines = {
    "import java.util.*;",
    "",
    "// LinkedList implementation",
    "class ListNode {",
    " int val;",
    " ListNode next;",
    " ListNode() {}",
    " ListNode(int val) { this.val = val; }",
    " ListNode(int val, ListNode next) { this.val = val; this.next = next; }",
    "}"
  }
  vim.api.nvim_put(lines, "l", true, true)
end, { desc = "Insert LinkedList template" })

vim.keymap.set("n", "<leader>jt", function()
  local lines = {
    "// TreeNode implementation",
    "class TreeNode {",
    " int val;",
    " TreeNode left;",
    " TreeNode right;",
    " TreeNode() {}",
    " TreeNode(int val) { this.val = val; }",
    " TreeNode(int val, TreeNode left, TreeNode right) {",
    "  this.val = val;",
    "  this.left = left;",
    "  this.right = right;",
    " }",
    "}"
  }
  vim.api.nvim_put(lines, "l", true, true)
end, { desc = "Insert TreeNode template" })

vim.keymap.set("n", "<leader>ji", function()
  local imports = {
    "import java.util.*;",
    "import java.io.*;",
    "import java.lang.*;",
    "import java.math.*;",
    ""
  }
  vim.api.nvim_put(imports, "l", false, true)
end, { desc = "Insert common Java imports" })

vim.keymap.set("n", "<leader>jf", function()
  local dir = vim.fn.expand("%:p:h")
  local input_file = dir .. "/input.txt"
  local output_file = dir .. "/output.txt"

  if vim.fn.filereadable(input_file) == 0 then
    vim.fn.writefile({""}, input_file)
  end
  if vim.fn.filereadable(output_file) == 0 then
    vim.fn.writefile({""}, output_file)
  end

  vim.cmd("split " .. input_file)
  print("Created input.txt and output.txt")
end, { desc = "Create input/output files" })

vim.keymap.set("n", "<leader>jp", function()
  local filename = vim.fn.expand("%:t:r")
  local lines = {
    "import java.util.*;",
    "import java.io.*;",
    "",
    "public class " .. filename .. " {",
    " public static void main(String[] args) throws IOException {",
    "  Scanner sc = new Scanner(System.in);",
    " ",
    "  // Your solution here",
    " ",
    "  sc.close();",
    " }",
    "}"
  }
  vim.api.nvim_put(lines, "l", true, true)
  vim.api.nvim_win_set_cursor(0, {vim.api.nvim_win_get_cursor(0)[1] + 7, 8})
  vim.cmd("startinsert!")
end, { desc = "Insert competitive programming template" })

-- Keymap for compiling and running Java file with dynamic input file
vim.keymap.set("n", ",ji", function()
  local dir = vim.fn.expand("%:p:h")
  local basename = vim.fn.expand("%:t:r")
  local java_file = vim.fn.expand("%:t")
  local input_file = dir .. "/" .. basename .. "_input.txt"

  -- Save current file
  vim.cmd("write")

  -- Create input file if doesn't exist
  if vim.fn.filereadable(input_file) == 0 then
    vim.fn.writefile({""}, input_file)
    print("Created " .. input_file)
  end

  -- Build Windows command string (unique buffer to avoid swap conflicts)
  local unique_buf_name = "JavaOutput_" .. basename
  local cmd = string.format(
    'cmd.exe /c "cd /d \"%s\" && javac \"%s\" && java \"%s\" < \"%s\""',
    dir, java_file, basename, input_file
  )

  local stdout = {}
  local stderr = {}

  vim.fn.jobstart(cmd, {
    stdout_buffered = true,
    stderr_buffered = true,
    on_stdout = function(_, data)
      if data then
        for _, line in ipairs(data) do
          table.insert(stdout, line)
        end
      end
    end,
    on_stderr = function(_, data)
      if data then
        for _, line in ipairs(data) do
          table.insert(stderr, line)
        end
      end
    end,
    on_exit = function(_, code, _)
      vim.schedule(function()
        local buf = vim.fn.bufnr(unique_buf_name)
        local win = nil

        -- Find existing window or create new split
        for _, w in ipairs(vim.api.nvim_list_wins()) do
          if vim.api.nvim_win_get_buf(w) == buf then
            win = w
            break
          end
        end

        if buf == -1 then
          vim.cmd("belowright split")
          buf = vim.api.nvim_get_current_buf()
          vim.api.nvim_buf_set_name(buf, unique_buf_name)
        elseif not win then
          vim.cmd("belowright split")
          vim.api.nvim_win_set_buf(vim.api.nvim_get_current_win(), buf)
          win = vim.api.nvim_get_current_win()
        else
          vim.api.nvim_set_current_win(win)
        end

        -- Set buffer options
        vim.bo[buf].buftype = "nofile"
        vim.bo[buf].bufhidden = "hide"
        vim.bo[buf].swapfile = false
        vim.bo[buf].modifiable = true

        -- Clear and set cleaned output
        vim.api.nvim_buf_set_lines(buf, 0, -1, false, {})

        if code == 0 then
          vim.api.nvim_buf_set_lines(buf, 0, -1, false, clean_lines(stdout))
        else
          vim.api.nvim_buf_set_lines(buf, 0, -1, false, clean_lines(stderr))
          vim.cmd('echohl ErrorMsg | echo ":Error running command (code ' .. code .. ')" | echohl None')
        end

        vim.api.nvim_win_set_cursor(win or vim.api.nvim_get_current_win(), {1, 0})
      end)
    end,
  })
end, { desc = "Compile and run Java with dynamic input file (Windows-safe, reuse buffer)" })

-- Fixed C++ compile & run: Alt+P (modern syntax, terminal split)
vim.keymap.set('n', '<A-p>', function()
  vim.cmd("write")  -- Save first
  vim.cmd("belowright split | term g++ % -o %<.exe && %<.exe")
end, { noremap = true, silent = true, desc = "Compile & run C++ (Windows)" })

-- Press <Esc> in terminal to go to Normal mode
vim.keymap.set("t", "<Esc>", [[<C-\><C-n>]], { noremap = true })

-- ─────────────────────────────────────────────────────────────
-- COMPREHENSIVE TRANSPARENCY CONFIGURATION
-- ─────────────────────────────────────────────────────────────

-- Function to apply complete transparency
local function apply_complete_transparency()
  vim.cmd([[
    " Core transparency
    hi Normal guibg=NONE ctermbg=NONE
    hi NormalNC guibg=NONE ctermbg=NONE
    hi EndOfBuffer guibg=NONE ctermbg=NONE
    hi NormalFloat guibg=NONE ctermbg=NONE
    hi FloatBorder guibg=NONE ctermbg=NONE

    " Telescope transparency
    hi TelescopeNormal guibg=NONE ctermbg=NONE
    hi TelescopeBorder guibg=NONE ctermbg=NONE

    " NvimTree complete transparency
    hi NvimTreeNormal guibg=NONE ctermbg=NONE
    hi NvimTreeNormalNC guibg=NONE ctermbg=NONE
    hi NvimTreeVertSplit guibg=NONE ctermbg=NONE
    hi NvimTreeWinSeparator guibg=NONE ctermbg=NONE
    hi NvimTreeEndOfBuffer guibg=NONE ctermbg=NONE
    hi NvimTreeCursorLine guibg=NONE ctermbg=NONE
    hi NvimTreeCursorColumn guibg=NONE ctermbg=NONE
    hi NvimTreeStatusLine guibg=NONE ctermbg=NONE
    hi NvimTreeStatusLineNC guibg=NONE ctermbg=NONE
    hi NvimTreeSignColumn guibg=NONE ctermbg=NONE

    " Window separators
    hi VertSplit guibg=NONE ctermbg=NONE
    hi WinSeparator guibg=NONE ctermbg=NONE

    " Tabline/Bufferline transparency (NvChad tabufline)
    hi TblineFill guibg=NONE ctermbg=NONE
    hi TbLineTabOn guibg=NONE ctermbg=NONE
    hi TbLineTabOff guibg=NONE ctermbg=NONE
    hi TbLineTabClose guibg=NONE ctermbg=NONE
    hi TblineButton guibg=NONE ctermbg=NONE
    hi TabLineFill guibg=NONE ctermbg=NONE
    hi TabLine guibg=NONE ctermbg=NONE
    hi TabLineSel guibg=NONE ctermbg=NONE

    " Statusline transparency (NvChad statusline)
    hi StatusLine guibg=NONE ctermbg=NONE
    hi StatusLineNC guibg=NONE ctermbg=NONE
    hi St_EmptySpace guibg=NONE ctermbg=NONE
    hi St_file_info guibg=NONE ctermbg=NONE
    hi St_gitIcons guibg=NONE ctermbg=NONE
    hi St_lspError guibg=NONE ctermbg=NONE
    hi St_lspWarning guibg=NONE ctermbg=NONE
    hi St_lspHints guibg=NONE ctermbg=NONE
    hi St_lspInfo guibg=NONE ctermbg=NONE
    hi St_cwd guibg=NONE ctermbg=NONE
  ]])
end

-- Apply transparency initially
apply_complete_transparency()

-- Apply after colorscheme changes
vim.api.nvim_create_autocmd("ColorScheme", {
  pattern = "*",
  callback = function()
    vim.defer_fn(apply_complete_transparency, 50)
  end,
})

-- Apply after NvChad base46 loads (crucial timing)
vim.api.nvim_create_autocmd("User", {
  pattern = "Base46CacheRead",
  callback = function()
    vim.defer_fn(apply_complete_transparency, 100)
  end,
})

-- Apply after everything loads
vim.api.nvim_create_autocmd("VimEnter", {
  pattern = "*",
  callback = function()
    vim.defer_fn(apply_complete_transparency, 200)
  end,
})

-- Force apply when NvimTree opens
vim.api.nvim_create_autocmd("FileType", {
  pattern = "NvimTree",
  callback = function()
    vim.defer_fn(apply_complete_transparency, 50)
  end,
})

-- ─────────────────────────────────────────────────────────────
-- UI SETTINGS
-- ─────────────────────────────────────────────────────────────
vim.opt.showtabline = 2 -- Show tabline (keep top bar visible)
vim.opt.laststatus = 3 -- Global statusline (keep bottom bar visible)
vim.opt.showmode = false -- Hide mode indicator
vim.opt.signcolumn = "no" -- Hide sign column
vim.opt.cmdheight = 0 -- Ultra clean cmdline

