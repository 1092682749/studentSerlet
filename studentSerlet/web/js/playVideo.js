var play = document.querySelectorAll(".footerOne button")[0];
var video = document.getElementsByTagName("video")[0];
var progressBar = document.getElementsByClassName("progressBar");
var progressPoint = document.getElementsByClassName("progressBarPoint")[0];
var videoProgress = document.getElementsByClassName("videoProgress")[0];
var volume = document.getElementsByClassName("volume")[0];
var currentVolume = document.getElementsByClassName("currentVolume")[0];
var volumePoint = document.getElementsByClassName("volumePoint")[0];
var volumeHeight;
console.log(volumePoint);
// console.log(typeof volume.style.);
// volume.style.height = "600px";
if(window.getComputedStyle)
{
    volumeHeight = window.getComputedStyle(volume,null).getPropertyValue('height');
}else {
    volumeHeight = volume.currentStyle["height"];
    if (volumeHeight == "auto") {
        volumeHeight = volume.offsetHeight;
    }
}
volumeHeight = parseInt(volumeHeight);
console.log( volumeHeight);
video.removeAttribute("controls");
// play.innerHTML = "&#x25BA;"
play.style.backgroundImage = "url('img/videoPause.png')";
play.style.backgroundSize = "25px 25px";
play.style.backgroundPosition = "center";
console.log(typeof play);
play.onclick = function () {

    if (video.paused)
    {
        play.style.backgroundImage = "url('img/videoPlay.png')";
        video.play();
    }else {
        play.style.backgroundImage = "url('img/videoPause.png')";
        video.pause();
    }
};

 function progressChange()
 {
      currentProgress = parseInt(video.currentTime);

      videoLenght = parseInt(video.duration);
     // console.log(1)
     pAndL = (currentProgress/videoLenght) * 550;
     // console.log(pAndL+"px");
     if (!isNaN(pAndL))
     {
         // console.log(progressPoint);
         progressPoint.style.left = pAndL + "px";
         videoProgress.style.width =  pAndL + "px";
     }

     // console.log(videoLenght)
 }
 var timer = setInterval(progressChange,50);
 var x=0,y=0;
 var pointMove = false;
 var volumeMove = false;


 progressPoint.onmousedown = function (e) {
     e = e || window.event;
     // console.log(1);
     clearInterval(timer);
     x = e.clientX - progressPoint.offsetLeft;
     pointMove = true;


 };

 volumePoint.onmousedown = function (e)
 {
     e = e || window.event;
     // y = e.clientY - volume.offsetTop;
     y = e.clientY;
     console.log("y is "+y);
     volumeMove = true;
 };

document.onmousemove = function (e){
     if (pointMove)
     {
         clearInterval(timer);
         e = e || window.event;
        progressPoint.style.left = e.clientX - x + "px";
        videoProgress.style.width = e.clientX - x + "px";
         pAndL = e.clientX - x;
         video.currentTime = (pAndL/550)*videoLenght;
         // console.log(parseInt((pAndL/550)*videoLenght));
         // console.log(video.currentTime);
     }
     if (volumeMove)
     {
         e = e || window.event;
         if(window.getComputedStyle)
         {
             volumePointBottom = window.getComputedStyle(volumePoint,null).getPropertyValue('bottom');
         }else {
             volumePointBottom  = volume.currentStyle["bottom"];
             if (volumePointBottom  == "auto") {
                 volumePointBottom  =100 - volumePoint.offsetTop;
             }
         }
         currentVolume.style.height = - (e.clientY - y) + "px";
         // console.log(volumeHeight - (e.clientY - y));
         // volumePoint.style.bottom = volumeHeight - (e.clientY - y)-190 + "px";
         vsb = parseInt("222222222222222"+volumePoint.style.bottom);
         volumePoint.style.bottom +=  - (e.clientY - y) + "px";
         console.log(volumePointBottom - (e.clientY - y) );
     }
 };
document.onmouseup = function (ev) {
    pointMove = false;
    volumeMove = false;
    timer = setInterval(progressChange,50);
}