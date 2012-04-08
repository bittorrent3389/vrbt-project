/*

This file is part of Ext JS 4

Copyright (c) 2011 Sencha Inc

Contact:  http://www.sencha.com/contact

GNU General Public License Usage
This file may be used under the terms of the GNU General Public License version 3.0 as published by the Free Software Foundation and appearing in the file LICENSE included in the packaging of this file.  Please review the following information to ensure the GNU General Public License version 3.0 requirements will be met: http://www.gnu.org/copyleft/gpl.html.

If you are unsure which license is appropriate for your use, please contact the sales department at http://www.sencha.com/contact.

*/
Ext.require('Ext.chart.*');
Ext.require(['Ext.Window', 'Ext.layout.container.Fit', 'Ext.fx.target.Sprite']);

Ext.onReady(function () {
	var strData=document.getElementById('spanDataColumnChart').innerHTML;
	stonecolumn.loadData(generateDataColumnChart());
    var win = Ext.create('widget.panel', {
    	width: 500,
        height: 300,
        hidden: false,
        maximizable: true,
        title: 'VRBT Chart',
        renderTo: Ext.Element.get('divColumnChartContainer'),
        layout: 'fit',
//        tbar: [{
//            text: 'Reload Data',
//            handler: function() {
//                store1.loadData(generateData());
//            }
//        }],
        items: {
            id: 'chartCmp',
            xtype: 'chart',
            style: 'background:#fff',
            animate: true,
            shadow: true,
            store: stonecolumn,
            axes: [{
                type: 'Numeric',
                position: 'left',
                fields: ['data1','data2'],
                label: {
                    renderer: Ext.util.Format.numberRenderer('0,0')
                },
                title: 'no purchase',
                grid: true,
                minimum: 0
            }, {
                type: 'Category',
                position: 'bottom',
                fields: ['name'],
                title: 'Month of the Year'
            }],
            series: [{
                type: 'line',
                axis: 'left',
                xField: 'name',
                yField: 'data2',
                tips: {
                    trackMouse: true,
                    width: 110,
                    height: 25,
                    renderer: function(storeItem, item) {
                        this.setTitle(storeItem.get('data2') + ' sale ' + storeItem.get('name').substr(0, 3));
                    }
                },
                style: {
                    fill: '#18428E',
                    stroke: '#18428E',
                    'stroke-width': 3
                },
                markerConfig: {
                    type: 'circle',
                    size: 4,
                    radius: 4,
                    'stroke-width': 0,
                    fill: '#18428E',
                    stroke: '#18428E'
                }
            }]
        }
    });
});

