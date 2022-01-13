# Compose Compiler Testbed

## Introduction

This repo is a reproducer for [KT-50482](https://youtrack.jetbrains.com/issue/KT-50482).

## Getting Start

- First of all, we need to init the submodule of this repo.

```shell
git submodule update --init --recursive
```

-  Next, we need to checkout a compose-native branch for JetBrains' Androidx.

```shell
cd support && git checkout compose-native-main-stale-2021-11-08
cd ..
```
- Then, we can try to reproduce the issue.

```shell
./gradlew :shared:linkDebugFrameworkIosArm64
```