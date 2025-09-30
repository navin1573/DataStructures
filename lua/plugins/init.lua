return {
  {
    "stevearc/conform.nvim",
    opts = require "configs.conform",
  },
  {
    "nvchad/menu",
    lazy = false,
    config = function()
      require("menu")
    end,
  },
  {
    "neovim/nvim-lspconfig",
    config = function()
      require "configs.lspconfig"
    end,
  },
  {
  "nvim-tree/nvim-tree.lua",
  opts = {
    filters = {
      custom = { "^.*\\.class$"  },  -- Hides all .class files
    },
  },
}

}

