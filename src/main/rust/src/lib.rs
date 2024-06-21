use robusta_jni::bridge;

#[bridge]
mod mymod {
    use robusta_jni::convert::{
        IntoJavaValue, Signature, TryFromJavaValue, TryIntoJavaValue,
    };
    use robusta_jni::jni::errors::Result as JniResult;
    use robusta_jni::jni::objects::AutoLocal;
    use robusta_jni::jni::JNIEnv;
    
    #[derive(Signature, TryIntoJavaValue, IntoJavaValue, TryFromJavaValue)]
    #[package(dev.ultreon.xypercode.mods)]
    pub struct MyMod<'env: 'borrow, 'borrow> {
        #[instance]
        raw: AutoLocal<'env, 'borrow>,
    }

    impl<'env: 'borrow, 'borrow> MyMod<'env, 'borrow> {
        #[constructor]        
        pub extern "java" fn new(env: &'borrow JNIEnv<'env>) -> JniResult<Self> {}
        
        pub extern "jni" fn nativeInit(self, _env: &JNIEnv) -> JniResult<()> {
            Ok(ModItems::registerItems(_env)?)
        }
        
        pub extern "java" fn onInitialize(&self, _env: &JNIEnv, i: i32, u: i32) -> JniResult<()> {}
    }

    #[derive(Signature, TryIntoJavaValue, IntoJavaValue, TryFromJavaValue)]
    #[package(dev.ultreon.xypercode.mods)]
    pub struct ModItems<'env: 'borrow, 'borrow> {
        #[instance]
        raw: AutoLocal<'env, 'borrow>,
    }

    impl<'env: 'borrow, 'borrow> ModItems<'env, 'borrow> {
        pub extern "java" fn registerItems(_env: &JNIEnv) -> JniResult<()> {}
    }
}
