# HeptaLinker

# 必须配置如下
```
    defaultConfig {
        minSdk = 26    最小支持26,在小了不行,sdk不支持,编译的时候就是这个
        externalNativeBuild {
            cmake {
                arguments ("-DANDROID_STL=c++_shared")    目前配置了这个,可以使用静态cxx,不过需要自己编译,否则只能也使用这个
                abiFilters("armeabi-v7a", "arm64-v8a")    支持arm64 其实
            }
        }

    }
    buildFeatures {
        prefab = true          使用prefab
    }
```

## gradle 引用
gradle.kts
```
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url = uri("https://jitpack.io") }
		}
	}

```
gradle.kts
```
	dependencies {
	        implementation("com.github.Thehepta:HeptaLinker:0.0.2")
	}
```