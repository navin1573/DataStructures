require "nvchad.mappings"

-- add yours here

local map = vim.keymap.set

map("n", ";", ":", { desc = "CMD enter command mode" })
map("i", "jk", "<ESC>")

vim.keymap.set("n", "<leader><CR>", function()
    vim.cmd("wall")

    local root = vim.fn.getcwd()
    local filepath = vim.fn.expand("%:p")
    local filename = vim.fn.expand("%:t")
    local classname = vim.fn.expand("%:t:r")
    local filedir = vim.fn.expand("%:p:h")

    -- Compile current java file
    local compile = vim.fn.system(
        'cd "' .. root .. '" && javac "' .. filepath .. '" 2>&1'
    )

    if vim.v.shell_error ~= 0 then
        vim.notify(compile, vim.log.levels.ERROR, {
            title = "Java Compile Error",
        })
        return
    end

    -- Run using root input/output
    local run = vim.fn.system(
        'cd "' .. root .. '" && java -cp "' .. filedir .. '" ' ..
        classname .. ' < input.txt > output.txt 2>&1'
    )

    if vim.v.shell_error ~= 0 then
        vim.notify(run, vim.log.levels.ERROR, {
            title = "Java Runtime Error",
        })
        return
    end

    vim.cmd("checktime")
    vim.cmd("redraw!")
end, { desc = "Run Java CP" })

local function cp_layout()
    vim.cmd("only")

    local root = vim.fn.getcwd()

    vim.cmd("vsplit " .. root .. "/input.txt")
    vim.cmd("vertical resize 45")

    vim.cmd("split " .. root .. "/output.txt")

    vim.cmd("wincmd h")
end

vim.keymap.set("n", "<leader>co", cp_layout, {
    desc = "Open CP Layout",
})
