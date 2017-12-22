/**
 * @Author: TayLQ create at October 21st, 2016
 * */

var link= window.location.href;
var pos = link.search("hi");
var path = link.substring(0, link.length - pos);

$(document).ready(function() {
	$('.himokuMeisaiTable tr').each(function() {
		$(this).find('td').each (function() {
			$(this).css("vertical-align", "middle");
		});
	 });
	$(".checkAll").click(function(){
	    $('input:checkbox').not(this).prop('checked', this.checked);
	});
	
	$("#binCd").blur(function(e) {
		 var val = $("#binCd").val();
		$.ajax({
		type : "POST",
		url : path+'NFMYGX0140/getBinName',
		data : {
			binCd : val
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

function getHimokuCd(val, id) {
	
	$.ajax({
		type : "POST",
		url : path+"NFMYGX0140/getHimokuName",
		data : {
			himokuCd : val
		},
			success : function(data) {
			$("#himokuCd" + id).text(data.result);
		},error : function(e) {
			alert(e);
		},done : function(e) {
			alert(e);
		}
	});
}

function getGyoshaCd(val, id){
	$.ajax({
		type : "POST",
		url : path+"NFMYGX0140/getGyoshaName",
		data : {
			gyoshaCd : val
		},
			success : function(data) {
			$("#gyoshaCd" + id).text(data.result);
		},error : function(e) {
			alert(e);
		},done : function(e) {
			alert(e);
		}
	});
}

$(".updateButton").click(function() {
	
	$.confirmMsgBox("更新を行います。よろしいですか？", function() {
	var jsList = [];
	
	$('.himokuMeisaiTable tr').each(function() {
		
		var item = {};
		
	    var action = $(this).find("td .action"); 
	    if(action.val() != undefined)
	    	item['action']= action.val(); 
	    
	    var himokuCd = $(this).find("td .himokuCd"); 
	    if(himokuCd.val() != undefined)
	    	item['himokuCd']= himokuCd.val().trim().toUpperCase();
	    
	    var oldHimokuCd = $(this).find("td .oldHimokuCd"); 
	    if(oldHimokuCd.val() != undefined)
	    	item['oldHimokuCd']= oldHimokuCd.val().trim().toUpperCase();
	    
	    var seikyuNengetsu = $(this).find("td .seikyuNengetsu"); 
	    if(seikyuNengetsu.val() != undefined)
	    	item['seikyuNengetsu']= seikyuNengetsu.val().trim().toUpperCase();
	    
	    var oldSeikyuNengetsu = $(this).find("td .oldSeikyuNengetsu"); 
	    if(oldSeikyuNengetsu.val() != undefined)
	    	item['oldSeikyuNengetsu']= oldSeikyuNengetsu.val().trim().toUpperCase();
	    
	    var bodyTeiseiKbn = $(this).find("td .bodyTeiseiKbn"); 
	    if(bodyTeiseiKbn.val() != undefined)
	    	item['bodyTeiseiKbn']=bodyTeiseiKbn.val();
	   
	    var bodyTeiseiKaisu = $(this).find("td .bodyTeiseiKaisu"); 
	    if(bodyTeiseiKaisu.val() != undefined)
	    	item['bodyTeiseiKaisu']=fomatNumber(bodyTeiseiKaisu.val());
	    
	    var gyoshaCd = $(this).find("td .gyoshaCd"); 
	    if(gyoshaCd.val() != undefined)
	    	item['gyoshaCd']=gyoshaCd.val().trim().toUpperCase();

	    var tankaTani = $(this).find("td .tankaTani");
	    if(tankaTani.val() != undefined)
	    	item['tankaTani']=tankaTani.val().trim().toUpperCase();
	    
	    var tanka = $(this).find("td .tanka"); 
	    if(tanka.val() != undefined)
	    	item['tanka']=fomatNumber(tanka.val());
	   
	    var uchiwakeBaseJuryo = $(this).find("td .uchiwakeBaseJuryo"); 
	    if(uchiwakeBaseJuryo.val() != undefined)
	    	item['uchiwakeBaseJuryo']=fomatNumber(uchiwakeBaseJuryo.val());
	    
	    var uchiwakeKutonJuryo = $(this).find("td .uchiwakeKutonJuryo"); 
	    if(uchiwakeKutonJuryo.val() != undefined)
	    	item['uchiwakeKutonJuryo']=fomatNumber(uchiwakeKutonJuryo.val());
	   
	    var uchiwakeChoJakuJuryo = $(this).find("td .uchiwakeChoJakuJuryo"); 
	    if(uchiwakeChoJakuJuryo.val() != undefined)
	    	item['uchiwakeChoJakuJuryo']=fomatNumber(uchiwakeChoJakuJuryo.val());
	    
	    var uchiwakeJikangaiJuryo = $(this).find("td .uchiwakeJikangaiJuryo"); 
	    if(uchiwakeJikangaiJuryo.val() != undefined)
	    	item['uchiwakeJikangaiJuryo']=fomatNumber(uchiwakeJikangaiJuryo.val());
	   
	    var uchiwakeSonotaJuryo = $(this).find("td .uchiwakeSonotaJuryo"); 
	    if(uchiwakeSonotaJuryo.val() != undefined)
	    	item['uchiwakeSonotaJuryo']=fomatNumber(uchiwakeSonotaJuryo.val());
	    
	    var uchiwakeBaseKingaku = $(this).find("td .uchiwakeBaseKingaku"); 
	    if(uchiwakeBaseKingaku.val() != undefined)
	    	item['uchiwakeBaseKingaku']=fomatNumber(uchiwakeBaseKingaku.val());
	    
	    var uchiwakeKutonKingaku = $(this).find("td .uchiwakeKutonKingaku"); 
	    if(uchiwakeKutonKingaku.val() != undefined)
	    	item['uchiwakeKutonKingaku']=fomatNumber(uchiwakeKutonKingaku.val());
	    
	    var uchiwakeChojakuKingaku = $(this).find("td .uchiwakeChojakuKingaku"); 
	    if(uchiwakeChojakuKingaku.val() != undefined)
	    	item['uchiwakeChojakuKingaku']=fomatNumber(uchiwakeChojakuKingaku.val());
	    
	    var uchiwakeJikagaiKingaku = $(this).find("td .uchiwakeJikagaiKingaku"); 
	    if(uchiwakeJikagaiKingaku.val() != undefined)
	    	item['uchiwakeJikagaiKingaku']=fomatNumber(uchiwakeJikagaiKingaku.val());
	   
	    var uchiwakeSonotaKingaku = $(this).find("td .uchiwakeSonotaKingaku"); 
	    if(uchiwakeSonotaKingaku.val() != undefined)
	    	item['uchiwakeSonotaKingaku']=fomatNumber(uchiwakeSonotaKingaku.val());
	    
    	if(!jQuery.isEmptyObject(item)) {
    		item = getCommonData(item);
    		jsList.push(item);
    	}
	 });
	
	var jsData = JSON.stringify(jsList);
	// console.log(jsData);
	
	$.ajax({url : path+"NFMYGX0140/save",
	        type : "POST",
	        data : jsData,
	        contentType: "application/json",
	        dataType: "json",
			success : function(data) {
				if(data.status=='0') {
	             	$.infoMsgBox(data.result, function() {
	             		$('#error').html("");
	             		location.href = path+'NFMYGX0100/init';
	             	});
	             }else{
					$('#error').html(data.result);
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
	})
});

$(".cancelButton").click(function() {
	$.confirmMsgBox("入力をキャンセルしますか？", function() {
		location.href = path+'NFMYGX0100/init';
	})
	
});

//Event click delete record
$(".himokuDeleteButton").click(function() {
	$.confirmMsgBox("費目を削除します。よろしいですか？", function() {
		
		var jsList = [];
		
		$('.himokuMeisaiTable tr').each(function() {
			
			var himokuCd = $(this).find("td .oldHimokuCd"); 
			var bodyTeiseiKbn = $(this).find("td .bodyTeiseiKbn"); 
			var bodyTeiseiKaisu = $(this).find("td .bodyTeiseiKaisu"); 
			var oldSeikyuNengetsu = $(this).find("td .oldSeikyuNengetsu"); 
		    var act = $(this).find("td .action"); 
			var rowIndex = this.rowIndex;
			
			$(this).find('input[type="checkbox"]:checked').each(function () {
		    	
		    	if (act!=undefined) {
					if (act.val()=="addNew") {
						
						var row = parseInt(rowIndex);
					    document.getElementById("himokuMeisaiTable").deleteRow(row);
					}else if(act.val()=="update") {
						var item = {};		    	
					    if(himokuCd.val() != undefined)
					    	item['oldHimokuCd']= himokuCd.val().trim();
					    
					    if(oldSeikyuNengetsu.val() != undefined)
					    	item['oldSeikyuNengetsu']= oldSeikyuNengetsu.val().trim();
					    
					    if(bodyTeiseiKbn.val() != undefined)
					    	item['bodyTeiseiKbn']=bodyTeiseiKbn.val();
					    
					    if(bodyTeiseiKaisu.val() != undefined)
					    	item['bodyTeiseiKaisu']=fomatNumber(bodyTeiseiKaisu.val());
				   
				    	if(!jQuery.isEmptyObject(item)) {
				    		item = getCommonData(item);
				    		jsList.push(item);
				    	}
					}
				}
		    });
		 });
		
		var jsData = JSON.stringify(jsList);
		if (jsData!="[]") {
			$.ajax({url : path+"NFMYGX0140/delete",
		        type : "POST",
		        data : jsData,
		        contentType: "application/json",
		        dataType: "json",
				success : function(data) {
					if(data.status=='0') {
		             	$.infoMsgBox(data.result, function() {
		             		$('#error').html("");
		             		location.href = path+'NFMYGX0100/init';
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
		}else{
			$.infoMsgBox("Select item please !", function() {
         		return false;
         	});
		}
		
	});
});

// Get common data
function getCommonData(item){
	
	item['seizoshoKbn']=$("#seizoshoKbn").val();
	item['sojoNoBasho']=$("#sojoNoBasho").val();
	item['sojoNoShubetsu']=$("#sojoNoShubetsu").val();
	item['sojoNoOban']=$("#sojoNoOban").val();
	item['sojoNoRenban']=$("#sojoNoRenban").val();
	item['headTeiseiKbn']=$("#headTeiseiKbn").val();
	item['headTeiseiKaisu']=$("#headTeiseiKaisu").val();
	item['seikyuNengetsu']=$("#seikyuNengetsu").val();
	item['binCd']=$("#binCd").val().trim();
	item['tsumikomiMinato']=$("#tsumikomiMinato").val().trim();
	item['ageMinato']=$("#ageMinato").val().trim(); 
	var daisu = $("#daisu").val().trim(); 
	item['daisu']= fomatNumber(daisu);
	var juryo = $("#juryo").val().trim();
	item['juryo']= fomatNumber(juryo);
	item['tsumiaiCd']=$("#tsumiaiCd").val().trim();
	var kihonYusoKyori = $("#kihonYusoKyori").val().trim();
	item['kihonYusoKyori']=fomatNumber(kihonYusoKyori);
	item['teiseiRiyu']= $("#teiseiRiyu").val().trim();	
	
	return item;
}

// Fomat number befor send request
function fomatNumber(data){
	var value = data.trim();
	return value.replace(",", "");
}

// Event click to add new button
$(".himokuAddButton").click(function() {
	var id = $('.himokuMeisaiTable >tbody >tr').length;
	id++;
	$('.himokuMeisaiTable tr:last').after(
		'<tr>'
    		+ '<td class="parts" style="vertical-align: middle;">'
    		+ '<input name="meisaiCheck" type="checkbox"></td>'
    		+ '<a href="#" class="removeItem"><span class="glyphicon glyphicon-remove-circle"></span></a></td>'
    		+ '<td style="vertical-align: middle;">'
    		+ '<input type="text" maxlength="2" class="form-control input-xsmall himokuCd" onchange="getHimokuCd(this.value,' + id + ');"><span id="himokuCd' + id + '"></span>'
            + '<input type="hidden" value="S" class="bodyTeiseiKbn">'
            + '<input type="hidden" value="0" class="bodyTeiseiKaisu">'
            + '<input type="hidden" value="addNew" class="action">'
            + '</td>'
            + '<td style="vertical-align: middle;"><input type="text" maxlength="3" class="form-control input-xsmall gyoshaCd"'
            + 'onchange="getGyoshaCd(this.value,' + id + ')"> <span id="gyoshaCd' + id + '"></span>'
			+ '</td>'
            + '<td style="vertical-align: middle;"><input type="text" maxlength="6" class="form-control input-small seikyuNengetsu"></td>'
            + '<td style="vertical-align: middle;"><input type="text" maxlength="1" class="form-control input-xsmall tankaTani"></td>'
            + '<td style="vertical-align: middle;">'
            + '<input type="text" maxlength="15" class="form-control input-small number tanka' + id + '" value="0" onchange="sum('+id+');"></td>'
            + '<td>'
            + '<input type="text" maxlength="15" class="form-control input-small number uchiwakeBaseJuryo' + id + '" value="0" onchange="sum('+id+');"><hr>'
                + '<input type="text" maxlength="15" class="form-control input-small number uchiwakeBaseKingaku' + id + '" onchange="sum('+id+');" value="0">'
                + '</td>'
                + '<td>'
                + '<input type="text" maxlength="15" class="form-control input-small number uchiwakeKutonJuryo' + id + '" onchange="sum('+id+');" value="0"><hr>'
                + '<input type="text" maxlength="15" class="form-control input-small number uchiwakeKutonKingaku' + id + '" onchange="sum('+id+');" value="0">'
                + '</td>'
                + '<td>'
                + '<input type="text" maxlength="15" class="form-control input-small number uchiwakeChoJakuJuryo' + id + '" onchange="sum('+id+');" value="0"><hr>'
                + '<input type="text" maxlength="15" class="form-control input-small number uchiwakeChojakuKingaku' + id + '" onchange="sum('+id+');" value="0">'
                + '</td>'
                + '<td>'
                + '<input type="text" maxlength="15" class="form-control input-small number uchiwakeJikangaiJuryo' + id + '" onchange="sum('+id+');" value="0"><hr>'
                + '<input type="text" maxlength="15" class="form-control input-small number uchiwakeJikagaiKingaku' + id + '" onchange="sum('+id+');" value="0">'
                + '</td>'
                + '<td>'
                + '<input type="text" maxlength="15" class="form-control input-small number uchiwakeSonotaJuryo' + id + '" onchange="sum('+id+');" value="0"><hr>'
                + '<input type="text" maxlength="15" class="form-control input-small number uchiwakeSonotaKingaku' + id + '" onchange="sum('+id+');" value="0">'
                + '</td><td>'
                + '<input type="text" value="0" maxlength="15" class="form-control input-small number" value="0" disabled id="totalJuryo'+id+'"><hr>'
                + '<input type="text" value="0" maxlength="15" class="form-control input-small number" value="0" disabled id="totalKingaku'+id+'">'
                + ' </td>'
                + '<td>'
            	+ '</td>'
    +'</tr>');
});

function sum(id){	
	$('.himokuMeisaiTable tr').each(function() {
		
		var baseJuryo=0;
		var kutonJuryo=0;
		var chojakuJuryo = 0;
		var jikagaiJuryo =0;
		var sonotaJuryo=0;
		var totalJuryo = 0;
		
		var baseKingaku=0;
		var kutonKingaku=0;
		var chojakuKingaku = 0;
		var jikagaiKingaku =0;
		var sonotaKingaku=0;
		var totalKingaku = 0;
		
		var action = $(this).find("td .action"); 
		if(action.val() =="addNew"){
			
			var tanka = $(this).find("td .tanka"+id); 
		    if(tanka.val() != undefined){
		    	if (!$.isNumeric(tanka.val())) {
		    		tanka.val("0");
				}
		    }
			 
		    var uchiwakeBaseJuryo = $(this).find("td .uchiwakeBaseJuryo"+id); 
		    if(uchiwakeBaseJuryo.val() != undefined){
		    	if (!$.isNumeric(uchiwakeBaseJuryo.val())) {
		    		uchiwakeBaseJuryo.val("0");
				}else{
					baseJuryo = fomatNumber(uchiwakeBaseJuryo.val());
				}
	    	}
		    
		    var uchiwakeKutonJuryo = $(this).find("td .uchiwakeKutonJuryo"+id); 
		    if(uchiwakeKutonJuryo.val() != undefined){
		    	if (!$.isNumeric(uchiwakeKutonJuryo.val())) {
		    		uchiwakeKutonJuryo.val("0");
				}else{
					kutonJuryo = fomatNumber(uchiwakeKutonJuryo.val());
				}
	    	}
		   
		    var uchiwakeChoJakuJuryo = $(this).find("td .uchiwakeChoJakuJuryo"+id); 
		    if(uchiwakeChoJakuJuryo.val() != undefined){
		    	if (!$.isNumeric(uchiwakeChoJakuJuryo.val())) {
		    		uchiwakeChoJakuJuryo.val("0");
				}else{
					chojakuJuryo = fomatNumber(uchiwakeChoJakuJuryo.val());
				}
		    }
		    
		    var uchiwakeJikangaiJuryo = $(this).find("td .uchiwakeJikangaiJuryo"+id); 
		    if(uchiwakeJikangaiJuryo.val() != undefined){
		    	if (!$.isNumeric(uchiwakeJikangaiJuryo.val())) {
		    		uchiwakeJikangaiJuryo.val("0");
				}else{
					jikagaiJuryo = fomatNumber(uchiwakeJikangaiJuryo.val());
				}
		    }
		    
		    var uchiwakeSonotaJuryo = $(this).find("td .uchiwakeSonotaJuryo"+id); 
		    if(uchiwakeSonotaJuryo.val() != undefined){
		    	if (!$.isNumeric(uchiwakeSonotaJuryo.val())) {
		    		uchiwakeSonotaJuryo.val("0");
				}else{
					sonotaJuryo = fomatNumber(uchiwakeSonotaJuryo.val());
				}
		    }
		    
		    var uchiwakeBaseKingaku = $(this).find("td .uchiwakeBaseKingaku"+id); 
		    if(uchiwakeBaseKingaku.val() != undefined){
		    	if (!$.isNumeric(uchiwakeBaseKingaku.val())) {
		    		uchiwakeBaseKingaku.val("0");
				}else{
					baseKingaku = fomatNumber(uchiwakeBaseKingaku.val());
				}
		    }
		    
		    var uchiwakeKutonKingaku = $(this).find("td .uchiwakeKutonKingaku"+id); 
		    if(uchiwakeKutonKingaku.val() != undefined){
		    	if (!$.isNumeric(uchiwakeKutonKingaku.val())) {
		    		uchiwakeKutonKingaku.val("0");
				}else{
					kutonKingaku = fomatNumber(uchiwakeKutonKingaku.val());
				}
		    }
		    
		    var uchiwakeChojakuKingaku = $(this).find("td .uchiwakeChojakuKingaku"+id); 
		    if(uchiwakeChojakuKingaku.val() != undefined){
		    	if (!$.isNumeric(uchiwakeChojakuKingaku.val())) {
		    		uchiwakeChojakuKingaku.val("0");
				}else{
					chojakuKingaku = fomatNumber(uchiwakeChojakuKingaku.val());
				}
		    }
		    
		    var uchiwakeJikagaiKingaku = $(this).find("td .uchiwakeJikagaiKingaku"+id); 
		    if(uchiwakeJikagaiKingaku.val() != undefined){
		    	if (!$.isNumeric(uchiwakeJikagaiKingaku.val())) {
		    		uchiwakeJikagaiKingaku.val("0");
				}else{
					jikagaiKingaku = fomatNumber(uchiwakeJikagaiKingaku.val());
				}
		    }
		   
		    var uchiwakeSonotaKingaku = $(this).find("td .uchiwakeSonotaKingaku"+id); 
		    if(uchiwakeSonotaKingaku.val() != undefined){
		    	if (!$.isNumeric(uchiwakeSonotaKingaku.val())) {
		    		uchiwakeSonotaKingaku.val("0");
				}else{
					sonotaKingaku = fomatNumber(uchiwakeSonotaKingaku.val());
				}
		    }
		    
		    
		    totalJuryo = parseInt(baseJuryo) + parseInt(kutonJuryo) + parseInt(chojakuJuryo)+parseInt(jikagaiJuryo)+parseInt(sonotaJuryo);
		    totalKingaku = parseInt(baseKingaku) + parseInt(kutonKingaku) + parseInt(chojakuKingaku)+parseInt(jikagaiKingaku)+parseInt(sonotaKingaku);
		    
		    $("#totalJuryo"+id).val(totalJuryo);
		    $("#totalJuryo"+id).val( $("#totalJuryo"+id).val().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,") );
		    $("#totalKingaku"+id).val(totalKingaku);
		    $("#totalKingaku"+id).val( $("#totalKingaku"+id).val().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,") );
			}	
		});
	}
