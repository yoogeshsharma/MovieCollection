<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="en">
<%@ include file="../../taglib.jsp" %>
<script>
	var toDelId = 0;
	jQuery(document).ready(function($){		
    	$('#movieListTblId').dataTable();
    	
    	$('button[name="delMovie"]').click(function() {
    		bootbox.confirm("Are you sure to delete Movie ?", function(result) {
    		    if (result) {    		        
    		        $.ajax({
     		              url: toDelId+'/deleteMovie.htm',   		              
     		              success: function(data) {     		            	 
     		              	 //refresh the current url
     		              	 location.reload();     		              	
     		              }
     		        });
    		    } 
    		});
    	  });
	});
	
</script>

<%@ include file="../../header.jsp"%>
<body>
	<div>
		<div class="panel panel-primary">
			<div class="panel-heading"><h4>Movie List</h4></div>
			<div class="panel-body">
				<div class="table-responsive">
					<table id="movieListTblId" 
						class="table table-striped table-bordered table-hover table-condensed">
						<thead>
							<tr>
								<th>SN.</th>
								<th>Title</th>
								<th>Format</th>
								<th>Length</th>
								<th>Year</th>
								<th>Rating</th>
								<th>Actions</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="listValue" items="${listMovie}" varStatus="cnt">
								<tr>
									<td>${cnt.count}</td>
									<td>${listValue.videoTitle}</td>
									<td>${listValue.videoFormat}</td>
									<td>${listValue.videoLengthMin} Min ${listValue.videoLengthSec} Sec</td>
									<td>${listValue.videoReleaseYear}</td>
									<td>${listValue.videoRating}</td>
									<td>
										<div class="btn-group">
											<button type="button" class="btn btn-primary btn-xs"
												onclick="location.href='${listValue.videoId}/editMovie.htm'">Edit</button>											
											<button class='btn btn-danger btn-xs' type="button"
												    onclick="toDelId=${listValue.videoId}" 
													name="delMovie" value="delete">
													<span class="fa fa-times"></span> Delete
											</button>
										</div>
									</td>
								</tr>
								</c:forEach>
						</tbody>
					</table>
					<button type="button" class="btn btn-primary"
						onclick="location.href='addMovie.htm'">Add</button>
				</div>
			</div>
		</div>
	</div>

	<div id="confirm" class="modal hide fade">
		<div class="modal-body">Are you sure to delete this Movie?</div>
		<div class="modal-footer">
			<button type="button" data-dismiss="modal" class="btn btn-primary"
				id="delete">Delete</button>
			<button type="button" data-dismiss="modal" class="btn">Cancel</button>
		</div>
	</div>

	<%@ include file="../../footer.html"%>

</body>
</html>