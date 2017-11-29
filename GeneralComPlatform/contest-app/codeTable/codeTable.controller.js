/**
 * Created by tjc on 2017/07/06.
 * 码表管理
 */
define(['angularAMD', 'gotop', 'ui-bootstrap', 'ui-countdown', 'contest-app/codeTable/codeTable.service',
        'common-app/common', 'datePicker', 'popup-message', 'angular-messages', 'ui-pagination'],
    function (angularAMD, gotop) {

        //延迟加载的module需要调用
        angularAMD.processQueue();

        //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
        return ['$scope', 'codeTable', function (s, codeTable) {

            /**
             * 返回顶部
             */
            gotop();

            /**
             *检测分页
             */
            s.$watch('currentPage', function (currentPage) {
                s.loadList();
            });

            /**
             * 得到码表列表
             */
            s.codeTableList = [];
            s.condition = {};
            s.currentPage = 1;//当前页数
            s.itemsPerPage = 10;//每页显示的条数
            s.totalItems = 0;//总条数
            s.loadList = function () {
                s.condition.currentPage = s.currentPage;
                s.condition.itemsPerPage = s.itemsPerPage;
                console.info(s.condition);
                codeTable.getCodeTableList(s.condition).then(function (data) {
                    s.codeTableList = data;
                });

                codeTable.getCodeTableListCount(s.condition).then(function (data) {
                    s.totalItems = data.totalItems;
                    changeDateState(s.totalItems, 5);//暂无数据的方法
                });
            };

            /**
             * 删除选择的数据
             */
            s.deleteCodeTable = function () {
                var chk = $("input[name='isCheck']:checked");
                var codes;
                if (chk.length != 0) {
                    if (chk.length == 1) {
                        codes = JSON.parse($(chk[0]).val()).param_code;
                    }
                    else {
                        codes = JSON.parse($(chk[0]).val()).param_code;
                        for (var i = 1; i < chk.length; i++) {
                            codes += "," + JSON.parse($(chk[i]).val()).param_code;
                        }
                    }

                    showMsg("confirm", getPrompt(3), function () {
                        codeTable.deleteByCodes(codes).then(function (data) {
                            showToast(getPrompt(1,'删除'));
                            s.loadList();
                        });
                    });
                }
                else {
                    showMsg("warning", getPrompt(4));
                }
            };

            /**
             * 搜索
             */
            s.searchObject = function () {
                s.condition.parentCode = null;
                s.loadList();
            };


            /**
             * 进入下一级
             */
            //存放每个等级的parentCode
            s.parentCodeArray=[];

            // 导航栏等级
            s.idLevel=1;
            //提取公共字符串
            s.intoId="#level";
            s.gotoNextLevel = function (name,codes,level) {
                //将每个级别的parentCode存入数组，方便返回父级
                s.parentCodeArray[s.idLevel]=codes;
                s.idLevel2 =s.idLevel+1;

                //在当前导航栏末尾添加一个span标签
                $(s.intoId+s.idLevel).after("<span style=color:#e6e9eb;" + "margin-left:-2px; id='"+"symbol"+s.idLevel2+"'>＞</span>"+
                    "<span style='color: #6cb7f1' id='"+"level"+s.idLevel2+"'>"+name+"</span>");
                //将当前的span改为a标签
                $(s.intoId+s.idLevel).html("<a onclick='gotoFather("+level+")'>"+$(s.intoId+s.idLevel).text() +"</a>");
                //更新当前等级
                s.idLevel=s.idLevel2;

                s.condition.paramText = null;
                s.condition.paramName = null;
            	s.condition.parentCode=codes;
                s.parentCode=codes;
                s.loadList();

                s.condition={};
            };

            /**
             * 进入父级，强制进入当前的上一级
             */
            window.gotoFather = function (level) {
                //删除当前节点的元素
                for(;s.idLevel>level;s.idLevel--){
                    $("#symbol"+s.idLevel).remove();
                    $(s.intoId+s.idLevel).remove();
                }
                //修改当前节点元素
                $(s.intoId+s.idLevel).html( "<span style='color: #6cb7f1'>"+$(s.intoId+s.idLevel).text()+"</span>");

                s.condition.parentCode=s.parentCodeArray[s.idLevel-1];
                s.parentCode=s.parentCodeArray[s.idLevel-1];
                s.loadList();
                s.condition={};

            };
        }];
    });
