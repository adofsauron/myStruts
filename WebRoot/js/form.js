function $(id)
{
	return document.getElementById(id);
}

function createXMLHttpRequest()
{
	if(window.XMLHttpRequest)
	{
		return new XMLHttpRequest();
	}
	else if (window.ActionXObject)
	{
		try
		{
			return new ActionXObject("MsXML2.XMLHTTP");
		}catch(e)
		{
			return new ActiveXObject("Miscrosoft.XMLHTTP");
		}
	}
}

function callBack(req)
{
	if(req.readyState == 4)
	{
		if(req.status!=200)
		{
			alert("status error: "+req.status);
		}	
		
		$('forAjax')['value'] = req.responseText;
		//alert(req.responseText);
		
		return req.responseText;
	}
}

function $ajax(method, url)
{
	var req = createXMLHttpRequest();
	req.open(method, url, true);
	req.onreadystatechange = function(){ res = callBack(req);};
	req.send(null);
}

function ajaxForm(id)
{
	var value = $(id)['value'];
	//$ajax("get", "http://localhost:8080/myStruts/ajax.action?value="+value);
	$ajax("get", "ajax.action?value="+value);
}
