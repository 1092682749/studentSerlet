<%@ page import="java.util.List" %>
<%@ page import="aaa.entity.Danmu" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2018/3/22
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="navigationbarBackImg" style="background-image: url('img/navigation_yirenzhixia.jpg');background-size: 100% 200px;">
    <div class="navigationbar">
        <div class="navigationbar_left">
            <ul class="nav">
                <li><a href="../111.html"><img id="bili" src="img/bili.png">主站</a></li>
                <li>画友</li>
                <li>游戏中心</li>
                <li>直播</li>
                <li>会员购</li>
                <li>周边</li>
                <li>移动端</li>
            </ul>
        </div>

        <div class="navigationbar_right">
            <div class="navigationDrop">
                <div class="navigation_drop">
                    <p class="userName">白子画</p><br>
                    <img class="hb" src="img/hb%20(1).png"> <img class="hb" src="img/hb%20(2).png">
                </div>
                <div id="hreadPic">
                    <img src="img/tx.jpg">
                </div>
            </div>
            <ul class="nav">
                <li>大会员</li>
                <li>消息</li>
                <li>动态</li>
                <li>稍后再看</li>
                <li>收藏夹</li>
                <li>历史</li>
                <li id="contribute">投稿</li>
            </ul>
            <!--<div id="contribute">投稿</div>-->
        </div>
    </div>
    <div id="search">
        <a class="rankButton"><img src="img/rank.png">排行榜</a>
        <form>
            <input class = "text" type="text">
            <button class="searchButton" type="submit"></button>
        </form>
    </div>
</div>
<div class="nav_menu">
    <ul>

        <li id="menuFirstLi">
            <span><img class="specialPic" src="img/home.png"> </span>
            首页
            <!--<div class="drop"></div>-->
        </li>

        <li>
            <span>0</span>
            动画
            <div class="drop">
                <ul>
                    <li><img src="img/leftArrow%20%20.png">MAD·AMV<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li>
                        <img src="img/leftArrow%20%20.png">MMD·3D<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li>
                        <img src="img/leftArrow%20%20.png">短片·手书·配音<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li>
                        <img src="img/leftArrow%20%20.png">综合<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                </ul>
            </div>
        </li>

        <li>
            <span>0</span>
            番剧
            <div class="drop">
                <ul>
                    <li><img src="img/leftArrow%20%20.png">连载动画<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">完结动画<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">资讯<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">官方延伸<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">新番时间表<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">番剧索引<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                </ul>
            </div>
        </li>

        <li>
            <span>0</span>
            国创
            <div class="drop">
                <ul>
                    <li><img src="img/leftArrow%20%20.png">国产动画<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">国产原创相关<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">布袋戏<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">资讯<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">新番时间表<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">国产动画索引<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                </ul>
            </div>
        </li>

        <li>
            <span>0</span>
            音乐
            <div class="drop">
                <ul>
                    <li><img src="img/leftArrow%20%20.png">原创音乐<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">翻唱<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">VACALOID·UTAYU<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">演奏<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">三次元音乐<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">OP/ED/OST<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">音乐选集<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                </ul>
            </div>
        </li>

        <li>
            <span>0</span>
            舞蹈
            <div class="drop">
                <ul>
                    <li><img src="img/leftArrow%20%20.png">宅舞<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">三次元舞蹈<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">舞蹈教程<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                </ul>
            </div>
        </li>

        <li>
            <span>0</span>
            游戏
            <div class="drop">
                <ul>
                    <li><img src="img/leftArrow%20%20.png">单机游戏<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">电子竞技<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">手机游戏<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">网络游戏<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">桌游棋牌<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">GVM<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">音游<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">Mugen<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                </ul>
            </div>
        </li>

        <li>
            <span>0</span>
            科技
            <div class="drop">
                <ul>
                    <li><img src="img/leftArrow%20%20.png">趣味科普人文<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">野生技术协会<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">演讲·公开课<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">星海<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">数码<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">机械<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">汽车<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                </ul>
            </div>
        </li>

        <li>
            <span>0</span>
            生活
            <div class="drop">
                <ul>
                    <li><img src="img/leftArrow%20%20.png">搞笑<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">日常<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">美食圈<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">动物圈<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">手工<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">绘画<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">ASMR<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">运动<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">其他<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                </ul>
            </div>
        </li>

        <li>
            <span>0</span>
            鬼畜
            <div class="drop">
                <ul>
                    <li><img src="img/leftArrow%20%20.png">鬼畜调教<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">音MAD<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">人力VOCALOID<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">教程演示<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                </ul>
            </div>
        </li>

        <li>
            <span>0</span>
            时尚
            <div class="drop">
                <ul>
                    <li><img src="img/leftArrow%20%20.png">美妆<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">服饰<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">健身<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">资讯<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                </ul>
            </div>
        </li>

        <li>
            <span>0</span>
            广告
            <div class="drop"></div>
        </li>

        <li>
            <span>0</span>
            娱乐
            <div class="drop">
                <ul>
                    <li><img src="img/leftArrow%20%20.png">综艺<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">明星<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">korea·相关<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                </ul>
            </div>
        </li>

        <li>
            <span>0</span>
            影视
            <div class="drop">
                <ul>
                    <li><img src="img/leftArrow%20%20.png">影视杂谈<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">影视剪辑<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">短片<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">预告·资讯<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">特摄<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                </ul>
            </div>
        </li>

        <li>
            <span>0</span>
            放映厅
            <div class="drop">
                <ul>
                    <li><img src="img/leftArrow%20%20.png">纪录片<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">电影<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                    <li><img src="img/leftArrow%20%20.png">电视剧<img class="rightArrow" src="img/rightArrow%20%20.png"></li>
                </ul>
            </div>
        </li>

        <li>
            <span><img class="specialPic" src="img/special.png"></span>
            专栏
        </li>

        <li>
            <span><img class="specialPic"  src="img/plan.png"></span>
            广场
            <div class="drop"></div>
        </li>

        <li>
            <span><img class="specialPic" src="img/live.png"></span>
            直播
            <div class="drop"></div>
        </li>

        <li>
            <span><img class="specialPic" src="img/blackhouse.png"></span>
            小黑屋
            <div class="drop"></div>
        </li>

        <li>
            <img src="img/meunBnjPic.png">
            <div class="drop"></div>
        </li>

    </ul>
</div>
<div style="position: relative;height: 658px">
    <div id="playBox">
        <div id="videoBox">
            <div class="videoTop">
                <a><</a>
                <a>一月新番</a>
                <a>></a>
            </div>
            <div class="videoOutBox">
                <video controls>
                    <source src="../img/vido.mp4">
                </video>
            </div>
            <div class="footerOne">
                <button class="play"></button>

                <div class="progressBar">
                    <div class="videoProgress"></div>
                    <div class="progressBarPoint"></div>
                </div>
                <div class="volume">
                    <div class="currentVolume"></div>
                    <div class="volumePoint"></div>
                </div>
                <img class="videoVice" src="img/videoVice.png">
                <img class="videoFullScreen" src="img/videoFullScreen.png">
            </div>
            <div class="footerTow"></div>
        </div>
        <div id="bulletScreen"></div>
    </div>
</div>
<div class="arc_toolbar_report"></div>
</body>
<script src="js/playVideo.js"></script>
</html>
