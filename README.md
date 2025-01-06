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
docker-compose build
```
これでdockerイメージがビルドされます。しばしお待ちください。  
ビルドが終わったら、
```
docker-compose up -d
```
でコンテナを立ち上げてください。 (-d オプションはプロセスのバックグラウンド実行です。)




## Reactプロジェクトの作成方法

React プロジェクトを始める  
https://ja.react.dev/learn/start-a-new-react-project

今はフレームワークでの利用が推奨されている。今回はフロントのみReactの想定なので、ViteかWebpackを使う。

※creat-react-appは2022年頃に非推奨・メンテナンスされなくなりました。それより古い記事だとcreate-react-appを使っていることが多いので、要注意。  
2024年現在だと古いライブラリを参照して、脆弱性が含まれてしまう。


このプロジェクトだとnodejsはdocker内のみインストールされるので、dockerコンテナの中でプロジェクトの初期化を行う。

- nodejsのあるコンテナに入る(コンテナが立ち上がっている前提)
```

```

- プロジェクト初期化～起動まで
```
npm create vite@latest

✔ Project name: … todo-vite-app
✔ Select a framework: › React
✔ Select a variant: › TypeScript

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

## Springプロジェクトの作成方法

STS（Spring Tool Sweet）やVSCodeでプロジェクトを作成できます。

- Spring Initializr でプロジェクトの作成  
https://spring.pleiades.io/quickstart

内部的にはSpring Initializer というWebサービスからプロジェクト作成しているので、そちらでプロジェクトを作成しても良いです。

https://start.spring.io/

プロジェクト作成をコード化したい場合は、curlでプロジェクト作成することも可能です。  
参考： curlを通してSpring Initializrを利用する  
https://dev.classmethod.jp/articles/spring-initializr-with-curl/

# Spring ビルド方法

STSでプロジェクト作って.jarファイルにビルドしてOK。
Mavenかgradleをつかう。


# docker compose コマンド集

docker compose build

docker compose up

docker compose up -d

docker compose ps
- コンテナの起動状態を確認します。

docker compose logs
- 起動しているコンテナのログを見ます。

# 参考文献

DockerでReact+TypeScriptの環境を構築する手順
https://qiita.com/kashimuuuuu/items/b5f35057dfe1980d053a

君（Spring bootのバックエンドとTypeScriptのフロントエンド）を（コンテナに）載せて
https://qiita.com/fsdg-r-moriyama/items/0a8c2ecf8cf0150476bc

Docker 環境と React (TypeScript) で最小フロントエンドを実装する：Spring Boot + MySQL
https://qiita.com/studio_meowtoon/items/7d4d0bf73e04e01be558


ReactアプリをDockerイメージ化
https://zenn.dev/jun_uen0/articles/531b1f5e25d539

PodmanでReactアプリケーションの環境構築『初心者向け』
https://qiita.com/zhangzhenji228/items/d55309bd4eee5cf3f359

参考：Create React Appは役割を終えました    
https://zenn.dev/nekoya/articles/dd0f0e8a2fa35f

Vite (ヴィート) で1分環境構築【React + TypeScript】  
https://zenn.dev/reasemi/articles/6869cebde469aa

初心者でも簡単！Docker ComposeでViteを使ってReact + TypeScriptアプリをサクッと立ち上げてみよう
https://zenn.dev/daichirouesaka/articles/9a79083523dd36

SpringBootのアプリケーションをDockerコンテナで動かす
https://qiita.com/ke_suke0215/items/1b0128c140dd051b5993

REST API の作成
https://spring.pleiades.io/guides/gs/rest-service


Groovyを知らない人のためのbuild.gradle読み書き入門
https://qiita.com/opengl-8080/items/a0bb31fb20cb6505188b

## VScodeでビルドする場合。

https://qiita.com/smats-rd/items/ec2dc566bfb4b92f04d5

## SpringでAPIを実装するガイド

https://spring.pleiades.io/guides/gs/rest-service

## トラブルシュート

DockerコンテナがRestarting状態から変化しなくなってしまった場合ログを見てみる
https://ysko909.github.io/posts/docker-container-gets-into-restarting-loop/

docker compose v2
https://zenn.dev/harpseal/articles/8dc2602ffe3365
