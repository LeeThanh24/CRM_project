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
                alert("This project has been using")
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


        if (listStringEnd[2]>(listStringStart[2]) ) {
            return true;
        } else if (listStringEnd[2]===(listStringStart[2])) {
            if (listStringEnd[1]>(listStringStart[1])) {
                return true;
            }
            if (listStringEnd[1]===(listStringStart[1]) ) {
                if (listStringEnd[0]>(listStringStart[0]) ) {
                    return true;
                }
                if (listStringEnd[0]===(listStringStart[0])) {
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

    $('#btn-add').click(function (e) {
        const name = $('#name').val()
        const start = $('#start').val()
        const end = $('#end').val()
        e.preventDefault()
        if (checkNullUndefined(name) || checkNullUndefined(start) || checkNullUndefined(end)) {
            alert("Added unsuccessfully")
        } else {
            if (checkValid(start,end))
            {
                $.ajax({
                    method: 'POST',
                    url: 'http://localhost:8080/api/jobs/add',
                    data:
                        {
                            name: name,
                            start: start,
                            end: end
                        }
                }).done(function (data) {
                    alert("Added successfully")
                })
            }else
            {
                alert("Date is not valid")
            }


        }


    })
})