#include <jni.h>
#include <iostream>
#include "com_example_mymod_MyMod.h"

extern "C" JNIEXPORT void JNICALL Java_com_example_mymod_MyMod_nativeInit(JNIEnv* env, jobject obj) {
    std::cout << "Hello from C++!" << std::endl;

    // Get the ModItems class
    jclass modItemsClass = env->FindClass("com/example/mymod/ModItems");
    if (modItemsClass == nullptr) {
        std::cerr << "Failed to find ModItems class" << std::endl;
        return;
    }

    // Get the registerItems method ID
    jmethodID registerItemsMethod = env->GetStaticMethodID(modItemsClass, "registerItems", "()V");
    if (registerItemsMethod == nullptr) {
        std::cerr << "Failed to find registerItems method" << std::endl;
        return;
    }

    // Call the registerItems method
    env->CallStaticVoidMethod(modItemsClass, registerItemsMethod);
}
