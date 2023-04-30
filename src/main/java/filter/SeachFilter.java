package filter;

public class SeachFilter {
    private String search ;

    public SeachFilter(String search) {
        this.search = search;
    }

    public String resultAfterSearch ()
    {
        search = search .toLowerCase();
        if (search.equals("home") ||search.equals("dash board"))
        {
            return "/index";
        }else if (search.equals("member") ||search.equals("members") ||search.equals("users") ||search.equals("user")  )
        {
            return "/usersRoles";
        }else if (search.equals("role") ||search.equals("roles")   )
        {
            return "/roles";
        }else if (search.equals("project") ||search.equals("projects")   )
        {
            return "/jobs";
        }else if (search.equals("task") ||search.equals("tasks")   )
        {
            return "/tasksStatusJobsUsers";
        }else if (search.equals("blank") ||search.equals("empty")   )
        {
            return "/blank";
        }else
        {
            return "/index";
        }
    }
}
