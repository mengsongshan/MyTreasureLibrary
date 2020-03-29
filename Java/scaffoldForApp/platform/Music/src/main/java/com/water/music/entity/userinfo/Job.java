package com.water.music.entity.userinfo;

public
class Job {
    private JobType jobType;
    private String jobName;

    public
    Job(JobType jobType, String jobName) {
        this.jobType = jobType;
        this.jobName = jobName;
    }

    public
    Job() {
    }

    public
    JobType getJobType() {
        return jobType;
    }

    public
    void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public
    String getJobName() {
        return jobName;
    }

    public
    void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public
    String toString() {
        return "Job{" + "jobType=" + jobType + ", jobName='" + jobName + '\'' + '}';
    }
}
