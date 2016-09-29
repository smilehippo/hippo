var path = require('path');
var webpack = require('webpack');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

// multiple extract instances
let extractCSS = new ExtractTextPlugin('common.css');
let extractLESS = new ExtractTextPlugin('styles.css');

module.exports = {
  entry: './main.js',
  output: {
    path: path.resolve(__dirname, './dist'),
    publicPath: '/dist/',
    filename: 'build.js'
  },
  resolveLoader: {
    root: path.join(__dirname, 'node_modules'),
  },
  module: {
    loaders: [
      {
        test: /\.vue$/,
        loader: 'vue'
      },
      //{
      //  test: /\.js$/,
      //  loader: 'babel',
      //  exclude: /node_modules/
      //},
      {
        test: /\.js$/,
        loader: 'babel',
        exclude: /node_modules/,
        query: {
          plugins: ['transform-runtime'],
          presets: ['es2015','stage-0']
        }
      },
      //{
      //  test: /\.(png|jpg|gif|svg)$/,
      //  loader: 'file',
      //  query: {
      //    name: '[name].[ext]?[hash]'
      //  }
      //}
      {test: /\.(png|jpg|gif)$/, loader: 'url-loader?limit=8192'}, // inline base64 URLs for <=8k images, direct URLs for the rest
      {test: /\.less$/,  loader: extractLESS.extract({
        fallbackLoader: "style-loader",
        loader: "css-loader!less-loader"
      }) }, // use ! to chain loaders
      {test: /\.css$/,  loader: extractCSS.extract({
        fallbackLoader: "style-loader",
        loader: "css-loader"
      }) },
      {
        test: /\.(png|jpg|gif|svg|ico)$/,
        loader: 'url-loader',
        query: {
          limit: 10000,
          name: 'assets/[name].[ext]'
        }
      },
      {
        test: /\.(woff2?|eot|ttf|otf|svg)(\?.*)?$/,
        loader: 'url-loader',
        query: {
          limit: 10000,
          name: 'fonts/[name].[ext]'
        }
      },
    ]
  },
  devServer: {
    historyApiFallback: true,
    noInfo: true,
    port: 8888
  },
  devtool: '#eval-source-map',
  plugins: [
    //new webpack.optimize.UglifyJsPlugin({
    //    output: {
    //        comments: false,
    //    },
    //    compress: {
    //        warnings: false
    //    }
    //})
    //new ExtractTextPlugin("[name].css")
    extractCSS,
    extractLESS
  ]
}

if (process.env.NODE_ENV === 'production') {
  module.exports.devtool = '#source-map'
  // http://vue-loader.vuejs.org/en/workflow/production.html
  module.exports.plugins = (module.exports.plugins || []).concat([
    new webpack.DefinePlugin({
      'process.env': {
        NODE_ENV: '"production"'
      }
    }),
    new webpack.optimize.UglifyJsPlugin({
      compress: {
        warnings: false
      }
    })
  ])
}
