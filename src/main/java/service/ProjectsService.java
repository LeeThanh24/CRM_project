package service;

import model.JobsModel;
import model.ProjectDetailModel;
import repository.JobsRepository;
import repository.ProjectRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectsService {
    ProjectRepository projectRepository= new ProjectRepository();

    public List<JobsModel> countAllJobs()
    {

        return new JobsRepository().countAllJobs();
    }

    public boolean deleteJob(int id )
    {

        return new JobsRepository().deleteJob(id) >0;
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
        return new JobsRepository().addNewJob(name,afterConvertStart,afterConvertEnd)>0;
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

    public String getAva (List<ProjectDetailModel> list ,String email )
    {
        ProjectDetailModel projectDetailModel = null;;
        for (ProjectDetailModel item: list
        ) {
            if (item.getEmail().equals(email))
            {
                projectDetailModel= item ;
                break;
            }
        }
        if (projectDetailModel !=null)
        {
            return projectDetailModel.getAva();
        }else
        {
            return "avaMale.png";
        }

    }
}
