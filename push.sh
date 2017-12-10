#!/bin/sh

setup_git() {
  git config --global user.email "elubecka@inf.eg.edu.pl"
  git config --global user.name "Elubecka"
}

commit_website_files() {
  git checkout -b masterr
  git add .
  git commit -m "Travis build: $TRAVIS_BUILD_NUMBER"
}

upload_files() {
  git push --quiet --set-upstream https://github.com/emilial/test4.git masterr
}

setup_git
commit_website_files
upload_files
