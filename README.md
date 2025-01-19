# これは何？

docker+front(react)+backend(spring) の勉強用に作成したdockerfileのテンプレートです。

# 環境構築手順

Dockerを利用できる環境を構築します。Rancher Desktopの利用を想定しています。

## 想定環境
- OS: Windows11, Windows10

## 構成
- フロント
    - React (TypeScript)
- バックエンド
    - Sring (Java)

## 手順

1. Rancher Desktopをインストールします。  
↓のページから「Download for Windows」を選択してください。

https://rancherdesktop.io/


インストールが終われば、PCを再起動してください。  
これでローカルのDocker環境構築は完了です。  
(Rancher DesktopのインストーラがWSLの設定もいい感じにやってくれます。)

以後、Rancher Desktopを起動している間、ローカルのターミナルでdockerコマンドが使用可能になります。

2. ターミナルを立ち上げて、このファイルがあるフォルダに移動します。  
VSCodeでターミナルを立ち上げてもいいです。  
このフォルダ（docker-sompose.ymlのあるフォルダ）に移動したら、以下のコマンドを実行します。
```
docker compose build
```
これでdockerイメージがビルドされます。しばしお待ちください。  
ビルドが終わったら、
```
docker compose up -d
```
でコンテナを立ち上げてください。 (-d オプションはプロセスのバックグラウンド実行です。)





# React起動方法
reactコンテナに入り、ビルド後にnpm run dev を実行する。

```
docker exec -it front /bin/bash

# 以下はコンテナ内で実行。
cd todo-vite-app
npm install
npm run dev
```

npm run dev までをDockerFileに記載したので、コンテナを起動して3000ポートを見ればReactの画面が表示されます。

- 参考：初心者でも簡単！Docker ComposeでViteを使ってReact + TypeScriptアプリをサクッと立ち上げてみよう
https://zenn.dev/daichirouesaka/articles/9a79083523dd36

webpackで環境構築も可能。そっちは各自調査してください。  

# Spring 環境構築

- STSを使う場合：
https://spring.pleiades.io/guides/gs/sts

- VsCodeを使う場合：
https://spring.pleiades.io/guides/gs/guides-with-vscode

VeCodeに「Extension Pack for Java Auto Config」を入れましょう。


# Spring 起動方法
Springのコンテナに入り、gradlew bootRunを実行する。
```
docker exec -it backend /bin/bash

# 以下はコンテナ内で実行。
./gradlew clean build
./gradlew bootRun
```

# その他
他の参考資料などは docs フォルダにまとめています。気になったらのぞいてみてください。

