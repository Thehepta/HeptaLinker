# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.22.1)

# Declares and names the project.

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

# 设置目标导入路径，这里是一行


#if (${RXDEBUG} STREQUAL OFF)
#    message("this is RXDEBUG OFF")
#else()
#    message("this is RXDEBUG ON")
#endif()
project(heptalinker)


add_subdirectory(ziparchive)

include_directories(ziparchive/include)
include_directories(include)
include_directories(ziparchive/base/include)


add_library( # Sets the name of the library.
        ${CMAKE_PROJECT_NAME}
        # Sets the library as a shared library.
        STATIC
        # Provides a relative path to your source file(s).
        elf_symbol_resolver.cpp
        miniz.c
        linker.cpp
        linker_soinfo.cpp
        linker_phdr.cpp
        linker_mapped_file_fragment.cpp
        linker_utils.cpp
        linker_debug.cpp
        linker_version.cpp
        linker_symbol.cpp
        linker_relocate.cpp
        linker_gnu_hash_neon.cpp
        jni_proxy.cpp
        soinfo_12_transform.cpp
        soinfo_11_transform.cpp
        soinfo_12L_transform.cpp
        entry.cpp
)

target_link_libraries( # Specifies the target library.
        ${CMAKE_PROJECT_NAME}
        # Links the target library to the log library
        # included in the NDK.
        ziparchive)