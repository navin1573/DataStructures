local plugins = {
  -- Mason for managing LSPs
  { "williamboman/mason.nvim", run = ":MasonUpdate" },
  { "williamboman/mason-lspconfig.nvim" },

  -- LSP Config
  { "neovim/nvim-lspconfig" },

  -- Autocompletion
  {
    "hrsh7th/nvim-cmp",
    requires = {
      "hrsh7th/cmp-nvim-lsp",
      "hrsh7th/cmp-buffer",
      "hrsh7th/cmp-path",
      "saadparwaiz1/cmp_luasnip",
    },
  },

  -- Snippets
  { "L3MON4D3/LuaSnip" },
  { "rafamadriz/friendly-snippets" },
}

return plugins
