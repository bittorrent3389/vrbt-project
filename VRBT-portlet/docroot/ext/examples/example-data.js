/*

This file is part of Ext JS 4

Copyright (c) 2011 Sencha Inc

Contact:  http://www.sencha.com/contact

GNU General Public License Usage
This file may be used under the terms of the GNU General Public License version 3.0 as published by the Free Software Foundation and appearing in the file LICENSE included in the packaging of this file.  Please review the following information to ensure the GNU General Public License version 3.0 requirements will be met: http://www.gnu.org/copyleft/gpl.html.

If you are unsure which license is appropriate for your use, please contact the sales department at http://www.sencha.com/contact.

*/
Ext.require(['Ext.data.*']);

Ext.onReady(function() {

    window.generateData = function(upload, sale){
    	var data = [],number;
  	  var strData=document.getElementById('spanDataPieChart').innerHTML;
  	  //document.getElementById('spanDataColumnChart').innerHTML="";
  	  var strDataArr=strData.split('@');
  	  for(var i=0;i<strDataArr.length;i++)
  	  {
  		  
//  		  window.alert(strDataArr[i].split('#')[0]+' : '+strDataArr[i].split('#')[1]);
  		  data.push({
  	            name: strDataArr[i].split('#')[0],
  	            data1: parseFloat(strDataArr[i].split('#')[1])});  

  	  }
  	  

  	  return data;
    };

    
  window.generateDataColumnChart = function(){
	  var data = [],number;
	  var strData=document.getElementById('spanDataColumnChart').innerHTML;
	  //document.getElementById('spanDataColumnChart').innerHTML="";
	  var strDataArr=strData.split('$');
	  for(var i=0;i<strDataArr.length-1;i++)
	  {
		  
		  var month=i+1;
		  data.push({
	            name: "month"+month,
	            data1: parseFloat(strDataArr[i].split('#')[0]),  
		  		data2: parseFloat(strDataArr[i].split('#')[1])});  

	  }
	  

return data;
  
};

    window.store1 = Ext.create('Ext.data.JsonStore', {
        fields: ['name', 'data1', 'data2', 'data3', 'data4', 'data5', 'data6', 'data7', 'data9', 'data9'],
        data: generateData()
    });
    
    window.stonecolumn = Ext.create('Ext.data.JsonStore', {
        fields: ['name', 'data1', 'data2', 'data3', 'data4', 'data5', 'data6', 'data7', 'data9', 'data9'],
        data: generateDataColumnChart()
    });
    
    window.storeNegatives = Ext.create('Ext.data.JsonStore', {
        fields: ['name', 'data1', 'data2', 'data3', 'data4', 'data5', 'data6', 'data7', 'data9', 'data9'],
        data: generateDataNegative()
    });
    window.store3 = Ext.create('Ext.data.JsonStore', {
        fields: ['name', 'data1', 'data2', 'data3', 'data4', 'data5', 'data6', 'data7', 'data9', 'data9'],
        data: generateData()
    });
    window.store4 = Ext.create('Ext.data.JsonStore', {
        fields: ['name', 'data1', 'data2', 'data3', 'data4', 'data5', 'data6', 'data7', 'data9', 'data9'],
        data: generateData()
    });
    window.store5 = Ext.create('Ext.data.JsonStore', {
        fields: ['name', 'data1', 'data2', 'data3', 'data4', 'data5', 'data6', 'data7', 'data9', 'data9'],
        data: generateData()
    });    
    
    
});

