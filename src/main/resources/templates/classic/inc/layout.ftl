<#macro layout title keywords description>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--[if IE]>
    <meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'/>
    <![endif]-->

    <meta name="keywords" content="mtons, ${keywords?default(options['site_keywords'])}">
    <meta name="description" content="${description?default(options['site_description'])}">
    ${options['site_metas']}
    <title>${title?default(options['site_name'])}</title>

    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <#--font-->
    <link rel="stylesheet" href="${base}/dist/vendors/font-awesome/css/all.min.css">
    <#--adminlte，包括bootstrap.css-->
    <link rel="stylesheet" href="${base}/dist/vendors/adminlte/css/adminlte.min.css">

<#--    <link href="${base}/dist/vendors/bootstrap/css/bootstrap.min.css">-->

    <#--my css-->
    <link href="${base}/dist/css/asule.css" rel="stylesheet"/>

    <!-- jQuery and bootstrap-->
    <script src="${base}/dist/js/jquery.min.js"></script>
    <script src="${base}/dist/vendors/bootstrap/js/bootstrap.min.js"></script>
    <script src="${base}/dist/vendors/layer/layer.js"></script>

    <#--adminLTE-->
    <script src="${base}/dist/vendors/adminlte/js/adminlte.js"></script>

    <script type="text/javascript">
        var _WANGQUE = _WANGQUE || {};
        _WANGQUE.BASE_PATH = '${base}';
        <#--_MTONS.LOGIN_TOKEN = '${profile.id}';-->
    </script>

    <script src="${base}/dist/js/sea.js"></script>
    <script src="${base}/dist/js/sea.config.js"></script>
</head>

<body>
    <#--navbar-->
    <#include "/classic/inc/head.ftl">

    <div class="wrapper">
        <#nested>
    </div>

    <#include "/classic/inc/footer.ftl">
</body>
</#macro>