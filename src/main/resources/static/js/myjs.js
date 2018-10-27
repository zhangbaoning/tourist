//ajax获取对象
function getXhr(){
	var xhr=null;
	if(window.XMLHttpRequest){
		xhr=new XMLHttpRequest();
	}else{
		xhr=new ActiveXObjext('Microsoft.XMLHttp');
	}
	return xhr;
}


//验证管理员登陆账号正则
function valiOpname(){
	document.getElementById("opname1").innerHTML="";
	var account=document.getElementById("opname").value;
	var reg=/^[A-Za-z0-9]{1,20}$/;
	var error=reg.test(account);
	if(!error){
		document.getElementById("opname1").innerHTML="20长度以内的字母和数字组合";
		document.getElementById("opname").value="";
	}
	return error;
}

//验证管理员登陆密码正则
function valiOppwd(){
	document.getElementById("oppwd1").innerHTML="";
	var account=document.getElementById("oppwd").value;
	var reg=/^[A-Za-z0-9]{6,15}$/;
	var error=reg.test(account);
	if(!error){
		document.getElementById("oppwd1").innerHTML="6到15长度以内的字母和数字组合";
		document.getElementById("oppwd").value="";
	}
	return error;
}

//验证用户注册时邮箱正则
function valiEmail(){
	document.getElementById("memail1").innerHTML="";
	var account=document.getElementById("memail").value;
	var reg=/^[A-Za-zd0-9]+([-_.][A-Za-zd0-9]+)*@([A-Za-zd0-9]+[-.])+[A-Za-zd]{2,5}$/; 
	var error=reg.test(account);
	if(!error){
		document.getElementById("memail1").innerHTML="请输入正确的邮箱";
		document.getElementById("memail").value="";
	}
	//ajax请求判断是否存在该用户
	var xhr=getXhr();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){
			var result=xhr.responseText;
			if(result==1){
				document.getElementById("memail1").innerHTML="该邮箱可以注册";
			}else{
				document.getElementById("memail1").innerHTML="该邮箱已被注册，请改用其他的邮箱注册！";
				document.getElementById("memail").value="";
			}
		}
	};
	xhr.open('get','../check/checkuser.do?email='+account,true);
	xhr.send(null);
	return error;
}

//验证用户注册时昵称正则
function valiNickname(){	
	document.getElementById("nickname1").innerHTML="";
	var account=document.getElementById("nickname").value;
	var reg=/^[a-zA-Z0-9\u4E00-\uFA29]{3,18}$/;
	var error=reg.test(account);
	if(!error){
		document.getElementById("nickname1").innerHTML="3到18位的汉字或英文数字组合";
		document.getElementById("nickname").value="";
	}
	
	//ajax请求判断是否存在该昵称
	var xhr=getXhr();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){
			var result=xhr.responseText;
			if(result==1){
				document.getElementById("nickname1").innerHTML="该昵称可以注册";
			}else{
				document.getElementById("nickname1").innerHTML="该昵称已被注册，请改用其他的昵称注册！";
				document.getElementById("nickname").value="";
			}
		}
	};
	xhr.open('get','../check/checkusernickname.do?nickname='+account,true);
	xhr.send(null);
	return error;
}

//验证用户注册时密码正则
function valiUserpwd(){	
	document.getElementById("userpwd1").innerHTML="";
	var account=document.getElementById("userpwd").value;
	var reg=/^[a-zA-Z0-9]{6,18}$/;
	var error=reg.test(account);
	if(!error){
		document.getElementById("userpwd1").innerHTML="6到18位英文数字组合";
		document.getElementById("userpwd").value="";
	}
	return error;
}

//验证用户注册时重复密码的判定
function valiUserpwdok(){
	document.getElementById("userpwdok1").innerHTML="";
	var account1=document.getElementById("userpwd").value;
	var account=document.getElementById("userpwdok").value;
	var error=account1==account;
	if(!error){
		document.getElementById("userpwdok1").innerHTML="两次密码输入不一致";
		document.getElementById("userpwdok").value="";
	}
	return error;
}

//验证用户登陆时邮箱正则
function valiEmail2(){
	document.getElementById("memail2").innerHTML="";
	var account=document.getElementById("demail").value;
	var reg=/^[A-Za-zd0-9]+([-_.][A-Za-zd0-9]+)*@([A-Za-zd0-9]+[-.])+[A-Za-zd]{2,5}$/; 
	var error=reg.test(account);
	if(!error){
		document.getElementById("memail2").innerHTML="请输入正确的邮箱";
		document.getElementById("demail").value="";
	}
	return error;
}

//验证用户注册时密码正则
function valiUserpwd2(){	
	document.getElementById("userpwd2").innerHTML="";
	var account=document.getElementById("duserpwd").value;
	var reg=/^[a-zA-Z0-9]{6,18}$/;
	var error=reg.test(account);
	if(!error){
		document.getElementById("userpwd2").innerHTML="6到18位英文数字组合";
		document.getElementById("duserpwd").value="";
	}
	return error;
}

//验证添加景点信息时景点名称是否中文且不超过所限定的长度
function valiVname(){	
	document.getElementById("verror1").innerHTML="";
	var account=document.getElementById("vname").value;
	var reg=/^[\u4E00-\uFA29]{3,18}$/;
	var error=reg.test(account);
	//ajax请求判断是否存在该用户
	var xhr=getXhr();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){
			var result=xhr.responseText;
			if(result==1){
				document.getElementById("verror1").innerHTML="该景区名可以使用";
				if(!error){
					document.getElementById("verror1").innerHTML="3到18位的汉字";
					document.getElementById("vname").value="";
				}
			}else{
				document.getElementById("verror1").innerHTML="该景区名已被使用，请改用其他的景区名使用！";
				document.getElementById("vname").value="";
			}
		}
	};
	xhr.open('get','../check/checkveiw1.do?vname='+account,true);
	xhr.send(null);
	return error;
}
	
//验证添加景点信息时内容路径是否为符合长度的英文
function valiPresent(){	
		document.getElementById("verror1").innerHTML="";
		var account=document.getElementById("present").value;
		var reg=/^[a-zA-Z]{6,18}$/;
		var error=reg.test(account);
		//ajax请求判断是否存在该用户
		var xhr=getXhr();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				var result=xhr.responseText;
				if(result==1){
					document.getElementById("verror1").innerHTML="该内容路径可以使用";
					if(!error){
						document.getElementById("verror1").innerHTML="6到18位的英文";
						document.getElementById("present").value="";
					}
				}else{
					document.getElementById("verror1").innerHTML="该内容路径已被使用，请改用其他的内容路径使用！";
					document.getElementById("present").value="";
				}
			}
		};
		xhr.open('get','../check/checkveiw2.do?present='+account,true);
		xhr.send(null);
		return error;
}

//验证添加景点信息时图片根目录是否为符合长度的英文
function valiViewphoto(){	
		document.getElementById("verror1").innerHTML="";
		var account=document.getElementById("veiwphoto").value;
		var reg=/^[a-zA-Z]{4,18}$/;
		var error=reg.test(account);
		//ajax请求判断是否存在该用户
		var xhr=getXhr();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				var result=xhr.responseText;
				if(result==1){
					document.getElementById("verror1").innerHTML="该图片路径可以使用";
					if(!error){
						document.getElementById("verror1").innerHTML="4到18位的英文";
						document.getElementById("veiwphoto").value="";
					}
				}else{
					document.getElementById("verror1").innerHTML="该图片路径已被使用，请改用其他的图片路径使用！";
					document.getElementById("veiwphoto").value="";
				}
			}
		};
		xhr.open('get','../check/checkveiw3.do?veiwphoto='+account,true);
		xhr.send(null);
		return error;
}

//提交添加景点信息时判断必填的是否为空
function valiVeiwSpotNull(){	
	var vname=document.getElementById("vname").value;
	var present=document.getElementById("present").value;
	var veiwphoto=document.getElementById("veiwphoto").value;
	var veiwphoto1=document.getElementById("imgHeadPhoto").src;
	var veiwphoto2=document.getElementById("imgHeadPhoto1").src;
	var present1=document.getElementById("present1").value;
	if(vname==""||present==""||veiwphoto==""
		||veiwphoto1==window.location.href
			||veiwphoto2==window.location.href
				||present1=="					"){
		alert("必须填写完毕才能提交");
		return false;
	}
	return true;
}

//图片预览
function PreviewImage(fileObj,imgPreviewId,divPreviewId){  
    var allowExtention=".png";//允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;  
    var extention=fileObj.value.substring(fileObj.value.lastIndexOf(".")+1).toLowerCase();              
    var browserVersion= window.navigator.userAgent.toUpperCase();  
    if(allowExtention.indexOf(extention)>-1){   
        if(fileObj.files){//HTML5实现预览，兼容chrome、火狐7+等  
            if(window.FileReader){
                var reader = new FileReader();   
                reader.onload = function(e){  
                    document.getElementById(imgPreviewId).setAttribute("src",e.target.result);
                }
                reader.readAsDataURL(fileObj.files[0]);  
            }else if(browserVersion.indexOf("SAFARI")>-1){  
                alert("不支持Safari6.0以下浏览器的图片预览!");  
            }  
        }else if (browserVersion.indexOf("MSIE")>-1){  
            if(browserVersion.indexOf("MSIE 6")>-1){//ie6  
                document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);  
            }else{//ie[7-9]  
                fileObj.select();  
                if(browserVersion.indexOf("MSIE 9")>-1)  
                    fileObj.blur();//不加上document.selection.createRange().text在ie9会拒绝访问  
                var newPreview =document.getElementById(divPreviewId+"New");  
                if(newPreview==null){  
                    newPreview =document.createElement("div");  
                    newPreview.setAttribute("id",divPreviewId+"New");  
                    newPreview.style.width = document.getElementById(imgPreviewId).width+"px";  
                    newPreview.style.height = document.getElementById(imgPreviewId).height+"px";  
                    newPreview.style.border="solid 1px #d2e2e2";  
                }  
                newPreview.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='" + document.selection.createRange().text + "')";                              
                var tempDivPreview=document.getElementById(divPreviewId);  
                tempDivPreview.parentNode.insertBefore(newPreview,tempDivPreview);  
                tempDivPreview.style.display="none";                      
            }  
        }else if(browserVersion.indexOf("FIREFOX")>-1){//firefox  
            var firefoxVersion= parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);  
            if(firefoxVersion<7){//firefox7以下版本  
                document.getElementById(imgPreviewId).setAttribute("src",fileObj.files[0].getAsDataURL());  
            }else{//firefox7.0+                      
                document.getElementById(imgPreviewId).setAttribute("src",window.URL.createObjectURL(fileObj.files[0]));  
            }  
        }else{  
            document.getElementById(imgPreviewId).setAttribute("src",fileObj.value); 
        }           
    }else{  
        alert("仅支持"+allowExtention+"为后缀名的文件!");  
        fileObj.value="";//清空选中文件  
        if(browserVersion.indexOf("MSIE")>-1){                          
            fileObj.select();  
            document.selection.clear();  
        }                  
        fileObj.outerHTML=fileObj.outerHTML;  
    } 
}

//验证添加新闻时新闻标题是否中文且不超过所限定的长度20
function valiNtilte(){	
	document.getElementById("verror1").innerHTML="";
	var account=document.getElementById("ntitle").value;
	var reg=/^[\u4E00-\uFA29]{3,20}$/;
	var error=reg.test(account);
	//ajax请求判断是否存在该用户
	var xhr=getXhr();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){
			var result=xhr.responseText;
			if(result==1){
				document.getElementById("verror1").innerHTML="该新闻标题可以使用";
				if(!error){
					document.getElementById("verror1").innerHTML="3到20位的汉字";
					document.getElementById("ntitle").value="";
				}
			}else{
				document.getElementById("verror1").innerHTML="该新闻标题已被使用，请改用其他的新闻标题使用！";
				document.getElementById("ntitle").value="";
			}
		}
	};
	xhr.open('get','../check/checknew1.do?ntitle='+account,true);
	xhr.send(null);
	return error;
}

//验证添加新闻时新闻来源的判定是否为中文，
function valiQuarry(){	
	document.getElementById("verror1").innerHTML="";
	var account=document.getElementById("quarry").value;
	var reg=/^[\u4E00-\uFA29]{2,20}$/;
	var error=reg.test(account);
	if(!error){
		document.getElementById("verror1").innerHTML="2到20位的汉字";
		document.getElementById("quarry").value="";
	}
	return error;
}

//验证添加新闻史新闻内容路径是否被占用，是否满足6到18位英文
function valiNpresent(){	
		document.getElementById("verror1").innerHTML="";
		var account=document.getElementById("present").value;
		var reg=/^[a-zA-Z]{6,18}$/;
		var error=reg.test(account);
		//ajax请求判断是否存在该用户
		var xhr=getXhr();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				var result=xhr.responseText;
				if(result==1){
					document.getElementById("verror1").innerHTML="该内容路径可以使用";
					if(!error){
						document.getElementById("verror1").innerHTML="6到18位的英文";
						document.getElementById("present").value="";
					}
				}else{
					document.getElementById("verror1").innerHTML="该内容路径已被使用，请改用其他的内容路径使用！";
					document.getElementById("present").value="";
				}
			}
		};
		xhr.open('get','../check/checknew2.do?present='+account,true);
		xhr.send(null);
		return error;
}

//验证添加新闻信息时图片根目录是否为符合长度的英文
function valiNewphoto(){	
		document.getElementById("verror1").innerHTML="";
		var account=document.getElementById("newphoto").value;
		var reg=/^[a-zA-Z]{4,18}$/;
		var error=reg.test(account);
		//ajax请求判断是否存在该用户
		var xhr=getXhr();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				var result=xhr.responseText;
				if(result==1){
					document.getElementById("verror1").innerHTML="该图片路径可以使用";
					if(!error){
						document.getElementById("verror1").innerHTML="4到18位的英文";
						document.getElementById("newphoto").value="";
					}
				}else{
					document.getElementById("verror1").innerHTML="该图片路径已被使用，请改用其他的图片路径使用！";
					document.getElementById("newphoto").value="";
				}
			}
		};
		xhr.open('get','../check/checknew3.do?newphoto='+account,true);
		xhr.send(null);
		return error;
}

//提交添加新闻信息时判断必填的是否为空
function valiNewNull(){	
	var ntitle=document.getElementById("ntitle").value;
	var quarry=document.getElementById("quarry").value;
	var present=document.getElementById("present").value;
	var newphoto=document.getElementById("newphoto").value;
	var newphoto1=document.getElementById("imgHeadPhoto").src;
	var newphoto2=document.getElementById("imgHeadPhoto1").src;
	var newphoto3=document.getElementById("imgHeadPhoto2").src;
	var present1=document.getElementById("present1").value;
	if(ntitle==""||quarry==""||present==""||newphoto==""
		||newphoto1==window.location.href
			||newphoto2==window.location.href
			||newphoto3==window.location.href
				||present1=="					"){
		alert("必须填写完毕才能提交");
		return false;
	}
	return true;
}

//验证前台发布游记时标题是否中文且不超过所限定的长度20
function valiTtitle(){	
	document.getElementById("terror").innerHTML="";
	var account=document.getElementById("title").value;
	var reg=/^[\u4E00-\uFA29]{3,20}$/;
	var error=reg.test(account);
	if(!error){
		document.getElementById("terror").innerHTML="3到20位的汉字";
		document.getElementById("title").value="";
	}
	return error;
}

//验证前台发布游记时内容路径是否满足6到18位英文
function valiPresent(){	
		document.getElementById("terror").innerHTML="";
		var account=document.getElementById("present").value;
		var reg=/^[a-zA-Z]{6,18}$/;
		var error=reg.test(account);
		//ajax请求判断是否存在该用户
		var xhr=getXhr();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				var result=xhr.responseText;
				if(result==1){
					document.getElementById("terror").innerHTML="该内容路径可以使用";
					if(!error){
						document.getElementById("terror").innerHTML="6到18位的英文";
						document.getElementById("present").value="";
					}
				}else{
					document.getElementById("terror").innerHTML="该内容路径已被使用，请改用其他的内容路径使用！";
					document.getElementById("present").value="";
				}
			}
		};
		xhr.open('get','../check/checkTravels.do?present='+account,true);
		xhr.send(null);
		return error;
}

//验证前台发布游记时图片路径是否满足6到18位英文
function valiTravelsphoto(){	
		document.getElementById("terror").innerHTML="";
		var account=document.getElementById("travelsphoto").value;
		var reg=/^[a-zA-Z]{6,18}$/;
		var error=reg.test(account);
		//ajax请求判断是否存在该用户
		var xhr=getXhr();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				var result=xhr.responseText;
				if(result==1){
					document.getElementById("terror").innerHTML="该图片路径可以使用";
					if(!error){
						document.getElementById("terror").innerHTML="6到18位的英文";
						document.getElementById("travelsphoto").value="";
					}
				}else{
					document.getElementById("terror").innerHTML="该图片路径已被使用，请改用其他的图片路径使用！";
					document.getElementById("travelsphoto").value="";
				}
			}
		};
		xhr.open('get','../check/checkTravels1.do?travelsphoto='+account,true);
		xhr.send(null);
		return error;
}

//提交提交时判断必填的是否为空
function valiTravelsNull(){	
	var title=document.getElementById("title").value;
	var present=document.getElementById("present").value;
	var travelsphoto=document.getElementById("travelsphoto").value;
	var newphoto1=document.getElementById("imgHeadPhoto").src;
	var newphoto2=document.getElementById("imgHeadPhoto1").src;
	var present1=document.getElementById("present1").value;
	if(title==""||present==""||travelsphoto==""
		||newphoto1==window.location.href
			||newphoto2==window.location.href
				||present1==""){
		alert("必须填写完毕才能提交");
		return false;
	}
	return true;
}

//前台发布问题是判断问题标题是否为汉字且字符长度符合要求
function valiQtitle(){	
	document.getElementById("qerror").innerHTML="";
	var account=document.getElementById("qtitle").value;
	var reg=/^[\u4E00-\uFA29]{3,20}$/;
	var error=reg.test(account);
	if(!error){
		document.getElementById("qerror").innerHTML="3到20位的汉字";
		document.getElementById("qtitle").value="";
	}
	return error;
}

//前台发布问题时
function valiQpresent(){	
	document.getElementById("qerror").innerHTML="";
	var account=document.getElementById("qpresent").value;
	var reg=/^{5,100}$/;
	var error=reg.test(account);
	if(!error){
		document.getElementById("qerror").innerHTML="5到100个字符以内";
		document.getElementById("qpresent").value="";
	}
	return error;
}

//提交提交时判断必填的是否为空
function valiQuestionNull(){
	var qtitle=document.getElementById("qtitle").value;
	var qpresent=document.getElementById("qpresent").value;
	if(qtitle==""||qpresent==""){
		alert("必须填写完毕才能提交");
		return false;
	}
	return true;
}

//前台个人信息页面上的简介判断
function valiResume(){	
	document.getElementById("nerror").innerHTML="";
	var account=document.getElementById("resume").value;
	var reg=/^[\u4E00-\uFA29]{3,100}$/;
	var error=reg.test(account);
	if(!error){
		document.getElementById("nerror").innerHTML="3到100位的汉字";
		document.getElementById("resume").value="";
	}
	return error;
}

//前台个人信息页面上的性别判断
function valiSex(){	
	document.getElementById("nerror").innerHTML="";
	var account=document.getElementById("sex").value;
	var reg=/^['男','女']$/;
	var error=reg.test(account);
	if(!error){
		document.getElementById("nerror").innerHTML="请输入男或女";
		document.getElementById("sex").value="";
	}
	return error;
}

//前台个人信息页面上的爱好判断
function valiHobby(){	
	document.getElementById("nerror").innerHTML="";
	var account=document.getElementById("hobby").value;
	var reg=/^[\u4E00-\uFA29]{0,10}$/;
	var error=reg.test(account);
	if(!error){
		document.getElementById("nerror").innerHTML="十个汉字以内";
		document.getElementById("hobby").value="";
	}
	return error;
}

//提交添加新闻信息时判断必填的是否为空
function valiNowUserNull(){	
	var nickname=document.getElementById("nickname").value;
	var userpwd=document.getElementById("password").value;
	if(nickname==""||userpwd==""){
		alert("必须填写完毕才能提交");
		return false;
	}
	return true;
}

