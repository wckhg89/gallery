module.exports = {
  css: {
    loaderOptions: {
      css: {
        test: /\.css$/,
        test: /\.woff$/,
      }
    }
  },
  outputDir: '../main/resources/static',
  devServer: {
    port: 3000,
    proxy: 'http://localhost:8080'
  }
};