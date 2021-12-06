$(document).ready(function() {

    $("#iniciar").click(function() {
        let email = $.trim($("#correo").val());
        let password = $.trim($("#contraseña").val());
        if (
            email != null &&
            password != null &&
            email.indexOf("@") != -1 &&
            email.indexOf(".") != -1
        ) {
            $.ajax({
                url: `http://localhost:8084/api/user/${email}/${password}`,
                type: "GET",
                success: function(result) {
                    if (result.id != null) {
                        console.log(result);
                        $("#usuario").empty("");
                        $("#usuario").append("Su Nombre de Usuario es: " + result.name);
                        $("#container-all").addClass("active")
                    } else {
                        alert("No existe un usuario");
                        clearInputs();
                    }

                }

            })
        } else {
            re = /^([\da-z_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            if (
                email == "" ||
                password == "")

            {
                alert("Todos los campos son obligatorios");

            } else if (!re.exec(email)) {
                alert("Correo No valido");

            }



        }



    })

})

function clearInputs() {
    $("#correo").value("");
    $("#contraseña").value("");
}