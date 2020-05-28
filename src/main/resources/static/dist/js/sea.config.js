seajs.config(
    {
        //sea.js的基础路径
        // base: _MTONS.BASE_PATH,

        //base不写，相对于sea.js
        alias:{
            // 'test':'/dist/js/test'

            'validate': 'dist/js/modules/validate',
            'validation': 'vendors/jquery-validation/jquery.validate.min.js',
            'validation-additional': 'vendors/jquery-validation/additional-methods.js',
            'validation-localization': 'vendors/jquery-validation/localization/messages_zh.min.js',

            'tagsinput': 'vendors/jquery-tagsinput/jquery.tagsinput',

            'post':'dist/js/modules/post',
        },

        paths:{
            'dist':_WANGQUE.BASE_PATH + '/dist',
            'vendors':_WANGQUE.BASE_PATH + '/dist/vendors'
        }
    }
);

// seajs.use('test');