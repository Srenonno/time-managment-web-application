/**
 * 
 */function dd() {
				alert($('input[name="naissance"]').val());
			}

			function save() {
				
				var token = $('#_csrf').attr('content');
				var header = $('#_csrf_header').attr('content');
				var a=[];
				a.push($("#role").val());
				var Role={
                 	 id :$("#role").val(),
                     name :$("#role").val()
                 };
               var  User={
                 	  nom : $("#nom").val(),
                 	prenom : $("#prenom").val(),
                 	email : $("#email").val(),
					password : $("#psw").val(),
					dateNaissance : $("#naissance").val(),
					dateEmbauche : $("#embauche").val(),
					roles:Role
                 };
                //alert( JSON.stringify(User));
				
				$.ajax({				
					url : '/admin/AjouterEmployer',
					type : 'POST',
					 beforeSend: function(xhr) {
                        xhr.setRequestHeader(header, token);
                    } ,  
                    dataType: 'json',
                    data : {
                    	 nom : $("#nom").val(),
                      	prenom : $("#prenom").val(),
                      	email : $("#email").val(),
     					password : $("#psw").val(),
     					dateNaissance : $("#naissance").val(),
     					dateEmbauche : $("#embauche").val(),
     				 	role:a, 
                    },
                    traditional: true,
					success : function(output) {
						location.reload();
					},
					error : function(output) {
						alert("mablanch");
					}
				});
			}