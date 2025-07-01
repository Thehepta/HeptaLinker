//
// Created by rzx on 2024/6/27.
//

#pragma once
#include "jni.h"

jobject FilehideLoadApkModule(JNIEnv *env, char * apkSource);
jobject memhideLoadApkModule(JNIEnv *env, unsigned char *apkSource, size_t i);
void Class_DexFile_Merge(JNIEnv *env,  char *apkSource, jobject classloader);

void *custom_dlopen(const char *file_path);
void *custom_dlsym(void *si, char* syn_name) ;
void *custom_dlopen(int fd);
void  PLT_HOOK();
