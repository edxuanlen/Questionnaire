// $(document).ready(function(){
//     $("#next_button").click(function(){
//         if($("#questionnaire_name").val() == "" || $("#questionnaire_describe").val() == "") {
//             alert("问卷名或问卷描述为空！");
//             return;
//         }
//     });
// });
function confirm(){
    if($("#questionnaire_name").val() == "" || $("#questionnaire_describe").val() == "") {
            alert("问卷名或问卷描述为空！");
            return false;
        }
}
