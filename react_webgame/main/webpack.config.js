const path = require('path'); // 경로 조작하는 모듈

module.exports = {
    name: 'wordrelay-setting',
    mode: 'development', // 실 서비스 에서는 production
    devtool: 'eval', 
    resolve: {
        extensions: ['.js', '.jsx']
    },

    entry: {
        app:['./client'],
    }, // 입력

    module: {
        rules: [{
            test: /\.jsx?/, // js, jsx 파일에 babel-loader적용
            loader: 'babel-loader',
            options: {
                presets: ['@babel/preset-env', '@babel/preset-react'],
                plugins: ['@babel/plugin-proposal-class-properties'],
            },
        }],
    }, // 모듈적용

    output: {
        path: path.join(__dirname, 'dist'),
        filename: 'app.js'
    } // 출력
};