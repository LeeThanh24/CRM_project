package service;

import model.JobsModel;
import model.ProjectDetailModel;
import model.UserRoleModel;
import repository.JobsRepository;
import repository.ProjectRepository;
import repository.UsersRolesRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectsService {
    ProjectRepository projectRepository= new ProjectRepository();

    UsersRolesRepository usersRolesRepository = new UsersRolesRepository() ;
    JobsRepository jobsRepository= new JobsRepository();

    public List<JobsModel> countAllJobs()
    {
        updateAllJobById();
        return jobsRepository.countAllJobs();
    }

    public List<JobsModel> filterJobs(int id , String projectName , String start ,String end )
    {

        return projectRepository.filterJobs(id,projectName,start,end);
    }
    public void updateAllJobById ()
    {
        List<JobsModel > jobs = jobsRepository.countAllJobs();
        for (int i = 1; i <=jobs.size() ; i++) {
            projectRepository.updateJobById(jobs.get(i-1).getId(),i);
        }
    }

    public boolean deleteJob(int id )
    {

        return jobsRepository.deleteJob(id) >0;
    }

    public boolean updateJob(String name ,String start ,String end  )
    {
        String []listStringStart = start.split("/");
        String afterConvertStart = "";
        afterConvertStart=listStringStart[2]+"/"+listStringStart[1] +"/"+listStringStart[0];

        //convert end
        String []listStringEnd = end.split("/");
        String afterConvertEnd = "";
        afterConvertEnd=listStringEnd[2]+"/"+listStringEnd[1] +"/"+listStringEnd[0];
        return jobsRepository.updateJob(name,afterConvertStart,afterConvertEnd) ;
    }

    public boolean addNewJob (String name , String start ,String end)
    {
        //convert start
        String []listStringStart = start.split("/");
        String afterConvertStart = "";
        afterConvertStart=listStringStart[2]+"/"+listStringStart[1] +"/"+listStringStart[0];

        //convert end
        String []listStringEnd = end.split("/");
        String afterConvertEnd = "";
        afterConvertEnd=listStringEnd[2]+"/"+listStringEnd[1] +"/"+listStringEnd[0];
        return jobsRepository.addNewJob(name,afterConvertStart,afterConvertEnd)>0;
    }

    public List<List<ProjectDetailModel>> countAllStatusOfProject()
    {
        return projectRepository.countAllStatusOfProject();
    }

    public List<ProjectDetailModel >  countDoers()
    {
        List<ProjectDetailModel > listName=  new ArrayList<>();
        List<String >listNameTemp = new ArrayList<>();
        List<List<ProjectDetailModel>> listProjectStatus = countAllStatusOfProject();
        for (List<ProjectDetailModel> subList:listProjectStatus
             ) {
            for (ProjectDetailModel item : subList
                 ) {
                if (!listNameTemp.contains(item.getName()))
                {
                    listNameTemp.add(item.getName());
                    listName.add(item);
                }
            }
        }
        return listName;
    }

    public String getAva ( String email )
    {
        return usersRolesRepository.findAvaByEmail(email);

    }
}
