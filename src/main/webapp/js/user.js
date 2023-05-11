$(document).ready(function () {

    $('.btn-xoa').click(function (e) {
        e.preventDefault()
        const id = $(this).attr("id")
        const This = $(this)
        $.ajax({
            method: 'POST',
            url: `http://localhost:8080/api/jobs/delete?id=${id}`,

        }).done(function (data) {
            if (data.data) {
                This.closest('tr').remove()
                console.log("Delete successfully !")
            } else {
                alert("This user has been using")

                console.log("Delete unsuccessfully !")
            }
        })
    })

    function checkNullUndefined(value) {
        return typeof value == 'string' && !value.trim() || typeof value == 'undefined' || value === null;
    }

    $('.btn-add').click(function (e) {
        const fullname = $('#fullname').val()
        const email = $('#email').val()
        const password = $('#pass').val()
        const phone = $('#phone').val()
        const id = $('#role').find('option:selected').attr('role_id')
        // $('option:role', this).attr("role_id")

        console.log(fullname + " " + email + " " + password + " " + id)
        if (checkNullUndefined(fullname) || checkNullUndefined(email) || checkNullUndefined(password) || checkNullUndefined(phone)) {
            e.preventDefault()
            alert("Added unsuccessfully")
        } else {
            e.preventDefault()
            $.ajax({
                method: 'POST',
                url: 'http://localhost:8080/api/usersRolesAdd',
                data:
                    {
                        fullname: fullname,
                        email: email,
                        password: password,
                        role_id: id
                    }
            }).done(function (data) {
                alert("Added successfully")
            })
        }

    })

    $('.btn-xoa').click(function (e) {
        const id = $(this).attr("id")
        const This = $(this)
        e.preventDefault()
        $.ajax({
            method: 'POST',
            url: `http://localhost:8080/api/usersRoles/delete`,
            data:
                {
                    id: id
                }
        }).done(function (data) {
            This.closest('tr').remove()
        })


    })

    $('.btn-update').click(function (e) {
            const fullname = $('#fullname').val()
            const password = $('#pass').val()
            const roleId = $('#role').find('option:selected').attr('role_id')
            let avatar = $('#ava').find('option:selected').attr('avaId')
            if (avatar === "1") {
                avatar = "avaMale.png"
            } else {
                avatar = "avaFemale.png"
            }
        e.preventDefault()
        $.ajax({
            method: 'POST',
            url: `http://localhost:8080/api/usersRoles/update`,
            data:
                {
                    roleId: roleId,
                    avatar: avatar,
                    fullname: fullname,
                    password: password
                }
        }).done(function (data) {
            if (data.data)
            {
                alert("Update successfully")
            }else
            {
                alert("Update successfully")
            }
        })


    })

})