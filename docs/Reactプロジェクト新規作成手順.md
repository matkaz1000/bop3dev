# Reactプロジェクトの作成方法

React プロジェクトを始める  
https://ja.react.dev/learn/start-a-new-react-project

今はフレームワークでの利用が推奨されている。今回はフロントのみReactの想定なので、ViteかWebpackを使う。

※creat-react-appは2022年頃に非推奨・メンテナンスされなくなりました。それより古い記事だとcreate-react-appを使っていることが多いので、要注意。  
2024年現在だと古いライブラリを参照して、脆弱性が含まれてしまう。


このプロジェクトだとnodejsはdocker内のみインストールされるので、dockerコンテナの中でプロジェクトの初期化を行う。

- nodejsのあるコンテナに入る(コンテナが立ち上がっている前提)
```

```

- プロジェクト初期化
```
npm create vite@latest

✔ Project name: … todo-vite-app
✔ Select a framework: › React
✔ Select a variant: › TypeScript
```
