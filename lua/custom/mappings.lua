local M = {}

M.telescope = {
  n = {
    ["<C-o>"] = {
      function()
        require("telescope.builtin").find_files()
      end,
      "Find files",
    },
  },
}

return M

