plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.heptalinker"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.heptalinker"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        externalNativeBuild {
            cmake {
                arguments ("-DANDROID_STL=c++_shared")

                abiFilters("armeabi-v7a", "arm64-v8a")
            }
        }

    }
    buildFeatures {
        viewBinding = true
        prefab = true
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    externalNativeBuild {
        cmake {
            path("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }


    ndkVersion = "27.0.12077973"
}



dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.heptalinker)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

tasks.configureEach {
    // 判断是否是 publish 类型的任务
    val isPublishTask = gradle.startParameter.taskNames.any {
        it.contains("publish", ignoreCase = true)
    }
    // 如果是 publish 类型任务，跳过当前模块所有任务
    onlyIf {
        !isPublishTask
    }
}

