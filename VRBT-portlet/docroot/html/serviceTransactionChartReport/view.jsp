<%@ include file="/html/init.jsp" %>

<aui:script>
	google.load("visualization", "1", {packages:["corechart"]});
	google.setOnLoadCallback(drawUsingServiceChart);
		
				function drawUsingServiceChart(){
					var dataChart = document.getElementById('usingService_Chart').innerHTML;
					var dataChartArr = dataChart.split('#');
					document.getElementById('usingService_Chart').innerHTML = "";
			
					var data = new google.visualization.DataTable();
				  	data.addColumn('string', 'Using Service');
				  	data.addColumn('number', 'Total');
		  	
		  			data.addRows([
				  		['Using service', parseInt(dataChartArr[0])],
				  		['Dont use', parseInt(dataChartArr[1])]
				  	]);
		  		
				  	var options = {
				  	    	title: 'Using Service',
				  	    	'width':600,
		                    'height':300,'backgroundColor':"#F1F3EF"
				  	  	};

		  			var chart = new google.visualization.PieChart(document.getElementById('usingService_Chart_div'));
		  			chart.draw(data, options);
				}
				
				
				google.setOnLoadCallback(drawUploadServiceChart);
				function drawUploadServiceChart(){
					
					var dataNameChart = document.getElementById('uploadServiceName_Chart').innerHTML;
					var dataNameChartArr = dataNameChart.split('#');
					document.getElementById('uploadServiceName_Chart').innerHTML = "";
				
					var dataChart = document.getElementById('uploadServiceTotal_Chart').innerHTML;
					var dataChartArr = dataChart.split('#');
					document.getElementById('uploadServiceTotal_Chart').innerHTML = "";
				
					var data = new google.visualization.DataTable();
			        data.addColumn('string', 'Upload Service Package');
		    	    data.addColumn('number', 'total');
		        
		        	var array = new Array();
			        for ( var i = 0; i < (dataChartArr.length - 1); i++) {
						array[i] = ([dataNameChartArr[i], parseInt(dataChartArr[i])]);
					}
		        
		    	    data.addRows(array);
		        
		        	var options = {
			  		    	title: 'Upload package service',
			  		    	'width':600,
		                    'height':300,'backgroundColor':"#F1F3EF"
			  	  		};
		        
			        var chart = new google.visualization.PieChart(document.getElementById('uploadService_Chart_div'));
			  		chart.draw(data, options);
				}
</aui:script>

<% 
	long serviceId_ServiceChart = ParamUtil.getLong(renderRequest, "cbServiceChart", 0);
	String serviceCode_ServiceChart = "";
	
	//long serviceId_servicePackageChart = ParamUtil.getLong(renderRequest, "cbServicePackageChart", 0);
	//String serviceCode_servicePackageChart = "";

	//Get data for service drop down list and get data for service which has service package
	List<ServiceEntry> listService = new ArrayList<ServiceEntry>();
	List<ServiceEntry> listServiceChart = new ArrayList<ServiceEntry>();
	//List<ServiceEntry> listServicePackageChart = new ArrayList<ServiceEntry>();
	
	listService = ServiceEntryLocalServiceUtil.findBystatus(1);
	
	if(listService.size() > 0){
		for(ServiceEntry serviceExt : listService){
			List<ServicePackageEntry> listPackage = new ArrayList<ServicePackageEntry>();
			
			if(ServicePackageEntryLocalServiceUtil.countByserviceId_status(serviceExt.getServiceId(), 1) > 0)
				listPackage = ServicePackageEntryLocalServiceUtil.findByserviceId_Status(serviceExt.getServiceId(), 1);
			
			if(listPackage.size() <= 0)
				listServiceChart.add(serviceExt);
			/* else
				listServicePackageChart.add(serviceExt); */
			
			if(serviceExt.getServiceId() == serviceId_ServiceChart)
				serviceCode_ServiceChart = serviceExt.getServiceCode();
			/* else 
				if(serviceExt.getServiceId() == serviceId_servicePackageChart)
					serviceCode_servicePackageChart = serviceExt.getServiceCode(); */
		}
	}
	
	//Get data about total user in using service
	ServiceEntry viewService = null;
	
	if(serviceId_ServiceChart == 0){	
		if(ServiceEntryLocalServiceUtil.countByserviceCode(ServiceEntryLocalServiceUtil.getStartServiceCode()) > 0)
			viewService = ServiceEntryLocalServiceUtil.findByserviceCode(ServiceEntryLocalServiceUtil.getStartServiceCode());
	}
	else{
		if(ServiceEntryLocalServiceUtil.countByserviceCode(serviceCode_ServiceChart) > 0)
			viewService = ServiceEntryLocalServiceUtil.findByserviceCode(serviceCode_ServiceChart);
	}
		
	if(viewService != null && viewService.getStatus() == 0)
		viewService = null;
	else
		serviceCode_ServiceChart = viewService.getServiceCode();
		
	//Get data about services which have package
	/* ServiceEntry viewServicePac = null;
	
	if(serviceId_servicePackageChart == 0){
		if(ServiceEntryLocalServiceUtil.countByserviceCode(ServiceEntryLocalServiceUtil.getUploadServicePackageCode()) > 0)
			viewServicePac = ServiceEntryLocalServiceUtil.findByserviceCode(ServiceEntryLocalServiceUtil.getUploadServicePackageCode());
	}
	else{
		if(ServiceEntryLocalServiceUtil.countByserviceCode(serviceCode_servicePackageChart) > 0)
			viewServicePac = ServiceEntryLocalServiceUtil.findByserviceCode(serviceCode_servicePackageChart);
	}
	
	List<ServicePackageEntry> listPackage = new ArrayList<ServicePackageEntry>();
	String packageName = "";
	String packageTotal = "";
		
	if(viewServicePac != null && viewServicePac.getStatus() == 0)
		viewServicePac = null;
	else 
		if(viewServicePac != null && viewServicePac.getStatus() == 1){
			if(ServicePackageEntryLocalServiceUtil.countByserviceId_status(viewServicePac.getServiceId(), 1) > 0)
				listPackage = ServicePackageEntryLocalServiceUtil.findByserviceId_Status(viewServicePac.getServiceId(), 1);
		
			if(listPackage != null && listPackage.size() >0){
				boolean isUse = false;
				for(ServicePackageEntry packageExt : listPackage){
					packageName += packageExt.getServicePackageName() + " - " + packageExt.getServicePackageName() + "#";
					
					long total = 0;
					try{
						total = UserServiceEntryLocalServiceUtil.countByservicePackageId(packageExt.getServicePackageId());
					}catch(Exception e){
						total = 0;
					}
				
					packageTotal += String.valueOf(total) + "#";
					
					if(total > 0)
						isUse = true;
				}
				
				serviceCode_servicePackageChart = viewServicePac.getServiceCode();
				
				if(!isUse){
					packageName = "Don't use#";
					packageTotal = "1#";
				}
			} else
				listPackage = null;		
		} */
%>

<portlet:actionURL var="viewChartURL" name="viewChart">
	<portlet:param name="serviceTransactionCode" value='<%= ParamUtil.getString(renderRequest, "serviceTransactionCode", "0") %>'/>
</portlet:actionURL>

<aui:form name="viewChartForm" method="post" action="<%= viewChartURL %>">
	<fieldset>
		<div>
			<ul>
				<aui:fieldset>
					<aui:column>
						<aui:select name="cbServiceChart" prefix="Select service to report: " label="" onChange="<%= viewChartURL %>">
							<aui:option label="Select service..." value="0" selected="true"/>
				
							<%for (ServiceEntry serviceExt : listServiceChart) { %>
								<aui:option label='<%= serviceExt.getServiceCode() + " - " + serviceExt.getServiceName() %>' 
									value="<%= serviceExt.getServiceId() %>"
									selected="<%= serviceExt.getServiceCode().equals(serviceCode_ServiceChart) %>"/>
							<% } %>
						</aui:select>
					</aui:column>
					
					<aui:column>
						<aui:button type="submit" value="Search" onClick="<%= viewChartURL %>"/>
					</aui:column>				
				</aui:fieldset>
			</ul>
		
			<ul>
				<c:if test="<%= viewService == null %>">
		 			<liferay-ui:message key="Service '001' is not started." />
				</c:if>

				<c:if test="<%= viewService != null %>">
					<!-- <span id="usingService_Chart" ><%= UserServiceEntryLocalServiceUtil.countByserviceId_ServiceStatus(viewService.getServiceId(), 1) %>
						#<%= UserEntryLocalServiceUtil.countByStatus(1) -  UserServiceEntryLocalServiceUtil.countByserviceId_ServiceStatus(viewService.getServiceId(), 1) %>
					</span>
	
					<script type="text/javascript" src="https://www.google.com/jsapi"></script>
					
					<script type="text/javascript">
						drawUsingServiceChart();
					</script>
	
					<div style="clear: both;">
						<div id="usingService_Chart_div" style="width:500px; height:300px;float: left; background-color:#F1F3EF;"></div>
					</div> -->
					
					 <link rel="stylesheet" type="text/css" href="<%=renderRequest.getContextPath()%>/ext/resources/css/ext-all.css" />
   			 		<link rel="stylesheet" type="text/css" href="<%=renderRequest.getContextPath()%>/ext/examples/shared/example.css" />
    				<script type="text/javascript" src="<%=renderRequest.getContextPath()%>/ext/bootstrap.js"></script>
    				<script type="text/javascript" src="<%=renderRequest.getContextPath()%>/ext/examples/example-data.js"></script>
    				<script type="text/javascript" src="<%=renderRequest.getContextPath()%>/ext/examples/charts/Pie.js"></script>
    				<script type="text/javascript" src="<%=renderRequest.getContextPath()%>/ext/examples/charts/Column.js"></script>
	
					<span id="spanDataPieChart" >In Use#<%= UserServiceEntryLocalServiceUtil.countByserviceId_ServiceStatus(viewService.getServiceId(), 1) %>
						@Not Use#<%= UserEntryLocalServiceUtil.countByStatus(1) -  UserServiceEntryLocalServiceUtil.countByserviceId_ServiceStatus(viewService.getServiceId(), 1) %>
					</span>
	
					<div style="clear: both;">
						<div id="divChartContainer" style="width:500px; height:300px;float: left; background-color:#F1F3EF;"></div>
					</div> 
					 
					<br style="clear:both" />
				</c:if>
			</ul>
		</div>
	</fieldset>

	<fieldset>
		<div>
			
			<%-- <ul>
				<aui:fieldset>
					<aui:column>
							<aui:select name="cbServicePackageChart" prefix="Select service to report: " label="" onChange="<%= viewChartURL %>">
							<aui:option label="Select service..." value="0" selected="true"/>
				
							<%for (ServiceEntry servicePacExt : listServicePackageChart) { %>
								<aui:option label='<%= servicePacExt.getServiceCode() + " - " + servicePacExt.getServiceName() %>' 
									value="<%= servicePacExt.getServiceId() %>"
									selected="<%= servicePacExt.getServiceCode().equals(serviceCode_servicePackageChart) %>"/>
							<% } %>
						</aui:select>
					</aui:column>
					
					<aui:column>
						<aui:button type="submit" value="Search" onClick="<%= viewChartURL %>"/>
					</aui:column>
				</aui:fieldset>
				
			</ul>
		
			<ul>
				<c:if test="<%= viewServicePac == null || listPackage == null %>">
					<liferay-ui:message key="Service '002' is not started or does not have package" />
				</c:if>
				
				<c:if test="<%= viewServicePac != null && listPackage!= null %>">
					<span id="uploadServiceName_Chart"><%= packageName %></span>
					<span id="uploadServiceTotal_Chart"><%= packageTotal %></span>
		
					<script type="text/javascript" src="https://www.google.com/jsapi"></script>
					<script type="text/javascript" src="/js/chartUtil.js"></script>
					<script type="text/javascript">
						drawUploadServiceChart();
					</script>
			
					<div style="clear: both; ">
						<div id="uploadService_Chart_div"  style="width:500px; height:300px;float: left; background-color:#F1F3EF;"></div>
					</div>
				</c:if>
			</ul> --%>
		</div>
	</fieldset>	
</aui:form>