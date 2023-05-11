$(document).ready(function () {
    $('.btn-xoa').click(function () {
        const id = $(this).attr("id")
        const This = $(this)
        console.log(id)
        $.ajax({
            method : 'POST',
            url  : `http://localhost:8080/api/tasksStatusJobsUsers/delete`,
            data :
                {
                    id:id
                }

        }).done(function (data)
        {
            if (data.data )
            {
                This.closest('tr').remove()
                console.log("Delete successfully !")
            }else
            {
                alert("This task has been using")

                console.log("Delete unsuccessfully !")
            }
        })
    })

    function checkNullUndefined(value) {
        return typeof value == 'string' && !value.trim() || typeof value == 'undefined' || value === null;
    }
    function checkValid(start, end) {
        const listStringStart = start.split("/");
        const listStringEnd = end.split("/");


        if (listStringEnd[2] > (listStringStart[2])) {
            return true;
        } else if (listStringEnd[2] === (listStringStart[2])) {
            if (listStringEnd[1] > (listStringStart[1])) {
                return true;
            } else if (listStringEnd[1] === (listStringStart[1])) {
                if (listStringEnd[0] > (listStringStart[0])) {
                    return true;
                } else if (listStringEnd[0] === (listStringStart[0])) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    $('.btn-add').click(function (e)
    {

        const job_id = $('#jobs').find('option:selected').attr('job_id')
        const taskName = $('#taskName').val()
        const doer_id = $('#doer').find('option:selected').attr('doer_id')
        const start = $('#start').val()
        const end = $('#end').val()
        const status_id = $('#status').find('option:selected').attr('status_id')

        if (checkNullUndefined(taskName) || checkNullUndefined(start) || checkNullUndefined(end) || checkValid(start,end) !==true)
        {
            alert("Added unsuccessfully")
            e.preventDefault()

        }else
        {
            e.preventDefault() //chan tat ca cac su kien mac dinh
            $.ajax({
                method : 'POST',
                url  : `http://localhost:8080/api/tasksStatusJobsUsers/add`,
                data :{
                    'taskName' :taskName,
                    'start' : start,
                    'end' : end,
                    'user_id' : doer_id,
                    'status_id' : status_id,
                    'job_id' : job_id
                }
            }).done(function (data)
            {
                alert("Added successfully")
            })

        }

    })

    $('.btn-update').click(function (e)
    {
        const job_id = $('#jobs').find('option:selected').attr('job_id')
        const taskName = $('#task').find('option:selected').attr('taskId')
        const doer_id = $('#doer').find('option:selected').attr('doer_id')
        const start = $('#start').val()
        const end = $('#end').val()
        const status_id = $('#status').find('option:selected').attr('status_id')

        if (checkValid(start,end)!==true)
        {
            alert("Date invalid")
            e.preventDefault()

        }else
        {
            e.preventDefault() //chan tat ca cac su kien mac dinh
            $.ajax({
                method : 'POST',
                url  : `http://localhost:8080/api/tasksStatusJobsUsers/update`,
                data :{
                    'taskName' :taskName,
                    'start' : start,
                    'end' : end,
                    'user_id' : doer_id,
                    'status_id' : status_id,
                    'job_id' : job_id
                }
            }).done(function (data)
            {
                if (data.data)
                {
                    alert("Updated successfully")
                }
                else
                {
                    alert("Updated unsuccessfully")
                }
            })

        }

    })


})