<%@ include file="/html/init.jsp" %>

<% 
	long serviceId_servicePackageChart = ParamUtil.getLong(renderRequest, "cbServicePackageChart", 0);
	String serviceCode_servicePackageChart = "";

	//Get data for service drop down list and get data for service which has service package
	List<ServiceEntry> listServicePac = new ArrayList<ServiceEntry>();
	List<ServiceEntry> listServicePackageChart = new ArrayList<ServiceEntry>();
	
	listServicePac = ServiceEntryLocalServiceUtil.findBystatus(1);
	
	if(listServicePac.size() > 0){
		for(ServiceEntry serviceExt : listServicePac){
			List<ServicePackageEntry> listPackage = new ArrayList<ServicePackageEntry>();
			
			if(ServicePackageEntryLocalServiceUtil.countByserviceId_status(serviceExt.getServiceId(), 1) > 0)
				listPackage = ServicePackageEntryLocalServiceUtil.findByserviceId_Status(serviceExt.getServiceId(), 1);
			
			if(listPackage.size() > 0)
				listServicePackageChart.add(serviceExt);
			
			if(serviceExt.getServiceId() == serviceId_servicePackageChart)
				serviceCode_servicePackageChart = serviceExt.getServiceCode();
		}
	}
		
	//Get data about services which have package
	ServiceEntry viewServicePac = null;
	
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
	String packageChartValue = "";
		
	if(viewServicePac != null && viewServicePac.getStatus() == 0)
		viewServicePac = null;
	else 
		if(viewServicePac != null && viewServicePac.getStatus() == 1){
			if(ServicePackageEntryLocalServiceUtil.countByserviceId_status(viewServicePac.getServiceId(), 1) > 0)
				listPackage = ServicePackageEntryLocalServiceUtil.findByserviceId_Status(viewServicePac.getServiceId(), 1);
		
			if(listPackage != null && listPackage.size() >0){
				boolean isUse = false;
				for(int i = 0; i < listPackage.size(); i++){
					ServicePackageEntry packageExt = listPackage.get(i);
					long total = 0;
					try{
						total = UserServiceEntryLocalServiceUtil.countByservicePackageId(packageExt.getServicePackageId());
					}catch(Exception e){
						total = 0;
					}
					
					if(total > 0)
						isUse = true;
					
					packageName += packageExt.getServicePackageName() + " - " + packageExt.getServicePackageName() + "#";
					packageTotal += String.valueOf(total) + "#";
					
					if(i==0)
						packageChartValue += packageExt.getServicePackageName()+"#"+String.valueOf(total);
					else
						packageChartValue += "@" + packageExt.getServicePackageName()+"#"+String.valueOf(total);
				}
				
				serviceCode_servicePackageChart = viewServicePac.getServiceCode();
				
				if(!isUse){
					packageName = "Don't use#";
					packageTotal = "1#";
				}
			} else
				listPackage = null;		
		}
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
										
					<link rel="stylesheet" type="text/css" href="<%=renderRequest.getContextPath()%>/ext/resources/css/ext-all.css" />
   			 		<link rel="stylesheet" type="text/css" href="<%=renderRequest.getContextPath()%>/ext/examples/shared/example.css" />
    				<script type="text/javascript" src="<%=renderRequest.getContextPath()%>/ext/bootstrap.js"></script>
    				<script type="text/javascript" src="<%=renderRequest.getContextPath()%>/ext/examples/example-data.js"></script>
    				<script type="text/javascript" src="<%=renderRequest.getContextPath()%>/ext/examples/charts/Pie.js"></script>
    				<script type="text/javascript" src="<%=renderRequest.getContextPath()%>/ext/examples/charts/Column.js"></script>
	
					<span id="spanDataPieChart" ><%= packageChartValue %></span>
	
					<div style="clear: both;">
						<div id="divChartContainer" style="width:500px; height:300px;float: left; background-color:#F1F3EF;"></div>
					</div>
				</c:if>
			</ul>
		</div>
	</fieldset>	
</aui:form>
