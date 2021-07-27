package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateWithEducationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
    @Query("select new kodlamaio.hrms.entities.dtos.CandidateWithEducationDto(c.id, c.firstName, c.lastName, e.graduationDate) " +
            "from Candidate c inner join c.resumes r " +
            "inner join r.school s inner join s.education e " +
            "order by c.id ASC, e.graduationDate DESC ")
    List<CandidateWithEducationDto> getCandidateByGraduationDate();
}
