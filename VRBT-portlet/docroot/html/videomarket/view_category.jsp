<%@ include file="/html/init.jsp" %>
<%@page import="java.util.Iterator"%>

 <% 
 	int total = 0;
	List<CategoryEntry> categoryEntries	= null;
 	try{
 		total = CategoryEntryLocalServiceUtil.getCategoryEntriesCount();
 		categoryEntries	= CategoryEntryLocalServiceUtil.getCategoryEntries(0,total);	
 	}catch(Exception e){}
	
  	if(categoryEntries==null){
  		categoryEntries = new ArrayList<CategoryEntry>();
  	}
  	Iterator<CategoryEntry> iter = categoryEntries.iterator();
  	CategoryEntry categoryEntry =null;
 %>




<style type="text/css">
ul.nav {
	list-style: none;
	display: block;
	
	/*background: url(/html/videomarket/img/shad2.png) no-repeat;
	width: 200px;
	position: relative;
	top: 100px;
	left: 100px;
	padding: 60px 0 60px 0;
	 */
	-webkit-background-size: 50% 100%;
}

ul.nav li {
	margin: 0px 0 0 0;
}

ul.nav li a {
	-webkit-transition: all 0.3s ease-out;
	/*background: #cbcbcb url(/html/videomarket/img/border.png) no-repeat;*/
	color: #174867;
	padding: 7px 15px 7px 15px;
	-webkit-border-top-right-radius: 10px;
 	-webkit-border-bottom-right-radius: 10px;
	width: 100px;
	display: block;
	text-decoration: none;
	-webkit-box-shadow: 2px 2px 4px #888;
}

ul.nav li a:hover {
	/*background: #ebebeb url(/html/videomarket/img/border.png) no-repeat;*/
	background:#5FBBE6;
	color: white;
	padding: 7px 15px 7px 30px;
}

</style>


<div>
	<ul class="nav" style="margin-left:0px;">
		<li> <div class="title" style="margin-top:-10px;">Video Categories</div> </li>
		<% while(iter.hasNext()){ 
			categoryEntry = iter.next();
		%>
		
			<li > 
				<portlet:renderURL  var="categoryURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>" >
					<portlet:param name="categoryId" value="<%=String.valueOf( categoryEntry.getCategoryId()) %>" />
					<portlet:param name="jspPage" value="/html/videomarket/videoArea.jsp" />
				</portlet:renderURL>
					<a href="<%= categoryURL.toCharArray() %>" title="<%= categoryEntry.getCategoryName() %>" class="categoryItem">
						  <%= categoryEntry.getCategoryName() %> 
					</a>
			</li>
		<%} %>
	</ul>
</div>

 