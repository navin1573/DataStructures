local lspconfig = require("lspconfig")

lspconfig.cssls.setup{
  filetypes = { "css", "scss", "less" },
  cmd = { "css-languageserver", "--stdio" },
  root_dir = lspconfig.util.root_pattern("package.json", ".git"),
}

