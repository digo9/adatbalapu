import { User } from './user.model';
import { Employer } from './employer.model';

export class JobOffer {

    public id?: number;

    public expectedSkill?: String;

    public candidateUsers?: User[];

    public offeringEmployer?: Employer;

    public description?: String;

}
