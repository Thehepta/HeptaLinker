#include <jni.h>
#include <string>

#include "heptalinker.h"

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_heptalinker_MainActivity_stringFromJNI(JNIEnv *env, jobject thiz) {
    // TODO: implement stringFromJNI()
    int a = add(4,5);
    std::string hello = "Hello from C++===";
    return env->NewStringUTF(hello.c_str());

}