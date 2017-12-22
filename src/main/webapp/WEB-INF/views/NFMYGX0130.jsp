<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NF&amp;M輸送費計算システム</title>
</head>
<body>
    <div id="wrapper">
    	<jsp:include page="/WEB-INF/views/common/header.jsp" />
        <div id="page-wrapper" >
			<div id="page-inner">
				<div class="row">
	                <div class="col-md-12">
	                 <h2>送状データ訂正</h2>   
	                </div>
	            </div>
	            <div class="alert alert-danger error-area" style="display: none;">
				  <strong>エラーです。</strong>
				</div>
	            <div id="error" style="color: red; font-size: 13px; font-weight: bold; margin-bottom: 5px"></div>
		         <div class="row">
		            <div class="col-sm-12 col-xs-12">
		        		<h5>出荷情報</h5>
			             	<table class="table-single table-bordered table-condensed col-md-12">
			                  <tr>
			                     <th class="caption col-md-2" >送状番号</th>
			                     <td class="form-inline col-md-4">${item.basho}-${item.shubetsu}-${item.oban}
			                     <input type="hidden" value="${item.basho}" id="basho">
			                     <input type="hidden" value="${item.shubetsu}" id="shubetsu">
			                     <input type="hidden" value="${item.oban}" id="oban">
			                     <input type="hidden" value="${item.date}" id="date">
			                     </td>
			                     <td class="caption col-md-2">出荷日</td>
			                     <td class="col-md-4">
			                     	<fmt:parseDate value="${item.date}" var="parsedshukkaDate" pattern="yyyyMMdd" />
									<fmt:formatDate pattern="yyyy/MM/dd" value="${parsedshukkaDate}"/>
			                     </td>
			                  </tr>
			                  <tr>
			                     <td class="caption col-md-2" >注文番号</td>
			                     <td>
			                     ${item.keiyear}-
			                     ${item.keikankatsu}-
			                     ${item.keihinshu}-
			                     ${item.keishubetsu}-
			                     ${item.keimonth}-
			                     ${item.keioban}
			                      <input type="hidden" value="${item.keiyear}" id="keiyear">
			                     <input type="hidden" value="${item.keikankatsu}" id="keikankatsu">
			                     <input type="hidden" value="${item.keihinshu}" id="keihinshu">
			                     <input type="hidden" value="${item.keishubetsu}" id="keishubetsu">
			                     <input type="hidden" value="${item.keimonth}" id="keimonth">
			                     <input type="hidden" value="${item.keioban}" id="keioban">
			                     </td>
			                     <td class="caption col-md-2">需要家</td>
			                     <td class="col-md-4">${item.kanji_01}</td>
			                  </tr>
			                  <tr>
			                     <td class="col-md-2 caption" >出庫場所</td>
			                     <td class="col-md-4">${item.kanji_02}</td>
			                     <td class="col-md-2 caption">物管1-4</td>
			                     <td class="col-md-4">${item.kanji_03}</td>
			                  </tr>
			                  
			                  <tr>
			                     <td class="col-md-2 caption" >受渡場所</td>
			                     <td class="col-md-4">${item.kanji_04}</td>
			                     <td class="col-md-2 caption">受渡条件</td>
			                     <td class="col-md-4">${item.kanji_05}</td>
			                  </tr>
			               </table>
		              </div>
		         </div>
		         <br>
		         
		         <!-- FORM USED TO -->
		         <div class="row">
		            <div class="col-sm-12 col-xs-12">
		        		<h5>輸送情報</h5>
			             	<table class="table-single table-bordered table-condensed col-md-12" id = "yusohiInfoTable">
			                  <tr>
			                     <th class="caption col-md-2">積港</th>
			                     <td class="col-md-4">
			                     	<input class="form-control input-xsmall" maxlength='4' value="${item.minato}" id="minato">
			                     </td>
			                     <th class="caption col-md-2">揚港</th>
			                     <td class="col-md-4">
			                     	<input class="form-control input-xsmall" type="text" maxlength='4' value="${item.age_minato}" id="age_minato">
			                     </td>
			                  </tr>
			                  <tr>
			                     <td class="caption col-md-2 required">重量</td>
			                     <td class="col-md-4 form-inline">
			                     	<input class="form-control input-medium number" maxlength='4' style="width:120px;" type="text" value="${item.juryo}" id="juryo">
			                     	<label>kg</label> 
			                     </td>
			                     <th class="caption col-md-2">検量料数</th>
				                 <td class="col-md-4"><input type="text" class="form-control input-small" value="${item.ryosu}" id="ryosu"/></td>
			                   </tr>
		                     <tr>
			                     <th class="caption col-md-2 required">便コード</th>
			                     <td class="col-md-4 form-inline">
			                     	<input type="text" class="form-control input-xsmall input-sm"  maxlength='3' value="${item.bincd}" style="width:60px;" id="bincd" name="bincd"/>
			                     	<label class="checkbox-inline">
			                     	<c:choose>
			                     		<c:when test="${size > 1}">
			                     		<input type="checkbox" class="fukusuBinCheckbox" checked="checked">複数便コード</label> 
			                     	</c:when>
			                     	<c:otherwise>
			                     		<input type="checkbox" class="fukusuBinCheckbox">複数便コード</label>
			                     	</c:otherwise>
			                     	</c:choose>
			                     	<br>
									<span class="binName" style="font-size: 12px;"></span>
			                     </td>
			                     <th class="caption col-md-2">倉庫保管日数</th>
		                     	 <td class="col-md-4"><input type="text" class="form-control input-small" value="${item.sokouhokan}" id="sokouhokan"/></td>
			                  </tr>
			                  <tr>
			                     <th class="caption col-md-2 required">業者コード</th>
			                     <td class="col-md-4"><input type="text" class="form-control input-xsmall" maxlength='3' value="${item.gyoshacd}" id="gyoshacd" name="gyoshacd"/></td>
			                     <th class="caption col-md-2">艀滞船日数</th>
			                     <td class="col-md-4"><input type="text" class="form-control input-small" value="${item.futaisen}" id="futaisen"/></td>
			                  </tr>
			                  <tr>
			                     <th class="caption col-md-2">積合コード</th>
			                     <td class="col-md-4"><input type="text" class="form-control input-xsmall" maxlength='2' value="${item.tsumiaicd}" id="tsumiaicd"/></td>
			                     <th class="caption col-md-2">時間外割増</th>
			                     <td class="col-md-4"><input type="text" class="form-control input-small" value="${item.jikangai}" id="jikangai"/></td>
			                  </tr>
			                  <tr>
			                     <th class="caption col-md-2">空トンコード</th>
			                     <td class="col-md-4"><input type="text" class="form-control input-xsmall" value="${item.kuton}" id="kuton"/></td>
			                     <th class="caption col-md-2">休日割増</th>
			                     <td class="col-md-4"><input type="text" class="form-control input-small" value="${item.kyuryo}" id="kyuryo"/></td>
			                  </tr>
			                  <tr>
			                     <th class="caption col-md-2">長尺</th>
			                     <td class="col-md-4"><input type="text" class="form-control input-xsmall" value="${item.chojaku}" id="chojaku"/></td>
			                     <th class="caption col-md-2">留置割増</th>
			                     <td class="col-md-4"><input type="text" class="form-control input-small" value="${item.tomeryo}" id="tomeryo"/></td>
			                  </tr>
			                  <tr>
			                     <th class="caption col-md-2">長尺１重量</th>
			                     <td class="col-md-4 form-inline">
			                     	<input type="text" class="form-control input-medium number" style="width:120px;" value="${item.cho1ju}" id="cho1ju"/>
			                     	<label>kg</label> 
			                     </td>
			                     <th class="caption col-md-2">浜出し区分</th>
			                     <td class="col-md-4">
			                     	<c:choose>
										<c:when test="${item.hanbai_kbn==0}">
											<label class="radio-inline">
												<input type="radio" name="radKm" id="radKm1" value="0" checked />なし
											</label>
											<label class="radio-inline">
												<input type="radio" name="radKm" id="radKm2" value="1" />10KMまで
											</label>
											<label class="radio-inline">
												<input type="radio" name="radKm" id="radKm3" value="2" />20KMまで
											</label>
										</c:when>
										<c:when test="${item.hanbai_kbn==1}">
											<label class="radio-inline">
												<input type="radio" name="radKm" id="radKm1" value="0" />なし
											</label>
											<label class="radio-inline">
												<input type="radio" name="radKm" id="radKm2" value="1" checked />10KMまで
											</label>
											<label class="radio-inline">
												<input type="radio" name="radKm" id="radKm3" value="2" />20KMまで
											</label>
										</c:when>
										<c:otherwise>
											<label class="radio-inline">
												<input type="radio" name="radKm" id="radKm1" value="0" />なし
											</label>
											<label class="radio-inline">
												<input type="radio" name="radKm" id="radKm2" value="1" />10KMまで
											</label>
											<label class="radio-inline">Z
												<input type="radio" name="radKm" id="radKm3" value="2" checked />20KMまで
											</label>
										</c:otherwise>
									</c:choose>
								</td>
			                  </tr>
			                  <tr>
			                     <th class="caption col-md-2">長尺２重量</th>
			                     <td class="col-md-4 form-inline">
			                     	<input type="text" class="form-control input-medium number" style="width:120px;" value="${item.cho2ju}" id="cho2ju"/>
			                     	<label>kg</label> 
			                     </td>
			                     <th class="caption col-md-2">別途協議</th>
			                     <td class="col-md-4 form-inline">
			                     	<input type="text" class="form-control input-medium number" style="width:120px;" value="${item.betto}" id="betto"/>
			                     	<label>円</label> 
			                     </td>
			                  </tr>
			                  <tr>
			                     <th class="caption col-md-2 required">台数</th>
			                     <td class="col-md-4" colspan ="3">
			                     	<input type="text" class="form-control input-small number"  value="${item.daisu}" id="daisu" name="daisu"/>
			                     </td>
			                  </tr>
			               </table>
		              </div>
		         </div>		         
		         <div class="row" id="fukusuBinRow">
		            <div class="col-md-12 col-sm-12 col-xs-12">
		            	<h5>便コード追加</h5>
						<table class="table-single table-bordered table-condensed col-md-12">
								<tr>
									<th class="caption col-md-2">便コード 1</th>
									<td class="col-md-2">									
										<input type="text" class="form-control input-xsmall number" maxlength='3' value="${item1.bincd}"  id="bincd_01"/>
									</td>
									<th class="caption col-md-2">重量 1</th>
									<td class="col-md-2 form-inline">
										<input type="text" class="form-control input-xsmall number" style="width:120px;" value="${item1.juryo}" id="juryo_01"/>
										<label>kg</label>
									</td>
									<th class="caption col-md-2">別途協議 1</th>
									<td class="col-md-2 form-inline">
										<input type="text" class="form-control input-medium number" style="width:120px;" value="${item1.betto}" id="betto_01"/>
										<label>円</label>
									</td>
									
								</tr>
								
								<tr>
									<th class="caption col-md-2">便コード 2</th>
									<td class="col-md-2">									
										<input type="text" class="form-control input-xsmall number" maxlength='3' value="${item2.bincd}"  id="bincd_02"/>
									</td>
									<th class="caption col-md-2">重量 2</th>
									<td class="col-md-2 form-inline">
										<input type="text" class="form-control input-xsmall number" style="width:120px;" value="${item2.juryo}" id="juryo_02"/>
										<label>kg</label>
									</td>
									<th class="caption col-md-2">別途協議 2</th>
									<td class="col-md-2 form-inline">
										<input type="text" class="form-control input-medium number" style="width:120px;" value="${item2.betto}" id="betto_02"/>
										<label>円</label>
									</td>
									
								</tr>
								<tr>
									<th class="caption col-md-2">便コード 3</th>
									<td class="col-md-2">									
										<input type="text" class="form-control input-xsmall number" maxlength='3' value="${item3.bincd}"  id="bincd_03"/>
									</td>
									<th class="caption col-md-2">重量 3</th>
									<td class="col-md-2 form-inline">
										<input type="text" class="form-control input-xsmall number" style="width:120px;" value="${item3.juryo}" id="juryo_03"/>
										<label>kg</label>
									</td>
									<th class="caption col-md-2">別途協議 3</th>
									<td class="col-md-2 form-inline">
										<input type="text" class="form-control input-medium number" style="width:120px;" value="${item3.betto}" id="betto_03"/>
										<label>円</label>
									</td>
								</tr>
								<tr>
									<th class="caption col-md-2">便コード 4</th>
									<td class="col-md-2">									
										<input type="text" class="form-control input-xsmall number" maxlength='3' value="${item4.bincd}"  id="bincd_04"/>
									</td>
									<th class="caption col-md-2">重量 4</th>
									<td class="col-md-2 form-inline">
										<input type="text" class="form-control input-xsmall number" style="width:120px;" value="${item4.juryo}" id="juryo_04"/>
										<label>kg</label>
									</td>
									<th class="caption col-md-2">別途協議 4</th>
									<td class="col-md-2 form-inline">
										<input type="text" class="form-control input-medium number" style="width:120px;" value="${item3.betto}" id="betto_04" />
										<label>円</label>
									</td>
								</tr>
						 </table>
	                </div>
		         </div>
		         <br>
		         <div class="row">
		            <div class="col-md-12 col-sm-12 col-xs-12">
	                 	<table class="table-single table-bordered table-condensed col-md-12">
		                  <tr>
		                     <td class="caption col-md-2 required">修正理由</td>
		                     <td class="col-md-10"><input type="text" class="form-control input-nolimit string-wide" id="teisei_riyu" name="teisei_riyu"></td>
		                  </tr>
		               </table>
	                 </div>
		         </div>
		         <br>
		         <div class="row">
		         	<div class = "col-sm-12 col-xs-12">
		         		<button class="btn btn-primary teiseiButton" type="submit"><i class="ic-commit"></i>訂正</button>		         		
		         		<a class="btn btn-default backButton" href="<c:url value="/NFMYGX0100/init"/>">キャンセル</a> 
		         	</div>
		         </div>
			</div>
	</div>
	<!-- /. PAGE WRAPPER  -->
	</div>

<c:url var="home" value="/" scope="request" />

<script>
$( document ).ready(function() {
	
	// if checked into checkbox, it's will show extra componants
	if ($(".fukusuBinCheckbox").is(':checked')) {
		$("#fukusuBinRow").removeClass("hide");
	}else {
		$("#fukusuBinRow").addClass("hide");
	}
	
	$("#bincd").blur(function(e) {
		// Stop form from submitting normally
		var bin_Cd = $("#bincd").val();
		$.ajax({
		type : "POST",
		url : "${home}NFMYGX0130/getBinName/",
		data : {
			binCd : bin_Cd
		},
		success : function(data) {
			$(".binName").text(data.result);
		},
		error : function(e) {
			alert(e);
		},
		done : function(e) {
			alert(e);
		}
		});
	});
});

// Toggle to show extra record ..
$(".fukusuBinCheckbox").click(function() {
	if ($(this).is(':checked')) {
		$("#fukusuBinRow").removeClass("hide");
	}else {
		$("#fukusuBinRow").addClass("hide");
	}
});

$("#bincd").keyup(function(event){
    if(event.keyCode == 13){
    	var bin_Cd = $("#bincd").val();
    	$.ajax({
    	type : "POST",
    	url : "${home}NFMYGX0130/getBinName/",
    	data : {
    		binCd : bin_Cd
    	},
    	success : function(data) {
    		$(".binName").text(data.result);
    	},
    	error : function(e) {
    		alert(e);
    	},
    	done : function(e) {
    		alert(e);
    	}
    	});
    }
    
});

// Save data by Ajax
$(".teiseiButton").click(function(e) {
	var search = {}
	
	search["basho"] = $("#basho").val();
	search["shubetsu"] = $("#shubetsu").val();
	search["oban"] = $("#oban").val();
	search["date"] = $("#date").val();	
	search["keiyear"] = $("#keiyear").val();
	search["keikankatsu"] = $("#keikankatsu").val();
	search["keihinshu"] = $("#keihinshu").val();
	search["keishubetsu"] = $("#keishubetsu").val();
	search["keimonth"] = $("#keimonth").val();
	search["keioban"] = $("#keioban").val();	
	search["minato"] = $("#minato").val().trim();
	search["age_minato"] = $("#age_minato").val().trim();
	search["juryo"] = $("#juryo").val().trim();
	search["ryosu"] = $("#ryosu").val().trim();
	search["bincd"] = $("#bincd").val().trim();
	search["sokouhokan"] = $("#sokouhokan").val().trim();
	search["gyoshacd"] = $("#gyoshacd").val().trim();
	search["futaisen"] = $("#futaisen").val().trim();
	search["tsumiaicd"] = $("#tsumiaicd").val().trim();
	search["jikangai"] = $("#jikangai").val().trim();
	search["kuton"] = $("#kuton").val().trim();
	search["kyuryo"] = $("#kyuryo").val().trim();
	search["chojaku"] = $("#chojaku").val().trim();
	search["tomeryo"] = $("#tomeryo").val().trim();
	search["cho1ju"] = $("#cho1ju").val().trim();
	search["cho2ju"] = $("#cho2ju").val().trim();
	search["betto"] = $("#betto").val().trim();
	search["daisu"] = $("#daisu").val().trim();
	
	var radKm = document.getElementsByName('radKm');
	var km;
	
	for(var i = 0; i < radKm.length; i++){
		if(radKm[i].checked){
			km = radKm[i].value;
		}
	}	   
	search["hanbai_kbn"] = km;
	
	if ($(".fukusuBinCheckbox").is(':checked')) {		
		search["bincd01"] = $("#bincd_01").val().trim();
		search["bincd02"] = $("#bincd_02").val().trim();
		search["bincd03"] = $("#bincd_03").val().trim();
		search["bincd04"] = $("#bincd_04").val().trim();
		
		search["juryo01"] = $("#juryo_01").val().trim();
		search["juryo02"] = $("#juryo_02").val().trim();
		search["juryo03"] = $("#juryo_03").val().trim();
		search["juryo04"] = $("#juryo_04").val().trim();
		
		search["betto01"] = $("#betto_01").val().trim();
		search["betto02"] = $("#betto_02").val().trim();
		search["betto03"] = $("#betto_03").val().trim();
		search["betto04"] = $("#betto_04").val().trim();
	}
	
	search["teisei_riyu"] = $("#teisei_riyu").val().trim();
			
     $.ajax({type : "POST",url : "${home}NFMYGX0130/save/", data : search, timeout : 100000, success : function(data) {
             if(data.status=='0') {
             	$.infoMsgBox(data.result, function() {
             		$('#error').html("");
             		location.href = '<c:url value="/NFMYGX0100/init"/>';
             	});
             	console.log("SUCCESS: ", data);
             }else{
             		var errorInfo = "";
					for (i = 0; i < data.result.length; i++) {
						errorInfo += "●" + data.result[i].defaultMessage + "<br/>";
					}
					$('#error').html(errorInfo);
             		console.log("FAIL: ", data);
             		
             		return false;
             }
         },
		error : function(e) {
			console.log("ERROR: ", e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
});

</script>
</body>
</html>