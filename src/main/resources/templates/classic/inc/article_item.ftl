<#macro article_item row escape=true>

    <#if row.thumbnail?? && row.thumbnail?length gt 0>

        <div class="home article-item">
            <div class="row">
                <div class="col-8">
                    <h3>
                        <a href="${base}/post/${row.id}">
                            <#if escape>${row.title?html}<#else>${row.title}</#if>
                        </a>
                    </h3>
                    <p class="color-content-1">
                        <a>${row.summary}</a>
                    </p>
                    <div class="article-info">
                        <div class="size-sm color-content-2">
                            <img class="img-circle"
                                 src="<@resource src=row.userVO.avatar + '?t=' + .now?time/>"
                                 style="width: 20px;height: 20px">
                            <span class="ml-2">${row.author.name}</span>
                            <i class="fa fa-calendar ml-2"></i> <span class="publish-date">${row.created}</span>
                            <i class="fa fa-eye ml-2"></i> <span class="article-view">${row.views}</span>
                        </div>

                        <div>
                            <a href="#" class="tag-blog-1 size-sm">Spring boot</a>
                        </div>
                    </div>
                </div>

                <div class="col-4" style="display: flex;align-items: center;justify-content: center;">
                    <div class="author-img">
                        <img
                             src="<@resource src=row.thumbnail/>"
                             style="width: 120px;height:120px">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-12 article-line"></div>
            </div>
        </div>

    </#if>



</#macro>