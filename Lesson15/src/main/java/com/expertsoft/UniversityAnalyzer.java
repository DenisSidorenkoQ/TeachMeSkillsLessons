package com.expertsoft;

import com.expertsoft.model.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniversityAnalyzer {
    /**
     * Should return min subject mark
     *
     * @param students  students stream
     * @param subjectId find min mark for subject with such id
     * @return
     */
    public OptionalInt getMinSubjectMark(Stream<Student> students, int subjectId)
    {
        return students.flatMap(student -> student.getSubjectMarks().stream())
                .filter(subjectMark -> subjectMark.getSubjectId() == subjectId)
                .mapToInt(SubjectMark::getMark)
                .min();
    }

    /**
     * Should return average mark given by teacher
     *
     * @param students  students stream
     * @param teacherId find average given mark for teacher with such id
     * @return
     */
    public OptionalDouble getAverageTeacherMark(Stream<Student> students, int teacherId) {
        return students.flatMap(student -> student.getSubjectMarks().stream())
                .filter(subjectMark -> subjectMark.getTeacherId() == teacherId)
                .mapToDouble(SubjectMark::getMark)
                .average();
    }

    /**
     * Should return min students age (years). Need to count the number of full years.
     *
     * @param students not empty students stream
     * @return
     */
    public Integer getMinStudentAgeInYears(Stream<Student> students) {
        return LocalDate.now().getYear() - students.map(Student::getBirthday)
                .max(LocalDate::compareTo)
                .get().getYear();
    }

    /**
     * Should return student with highest average mark.
     * If two or more students have the same average mark, then return any of this students.
     *
     * @param students not empty students stream
     * @return
     */
    public Student getStudentWithHighestAverageMark(Stream<Student> students) {
        List<Student> list = students.sorted(Comparator.comparing(student -> {
            return student.getSubjectMarks().stream().collect(Collectors.averagingDouble(SubjectMark::getMark));}))
                .collect(Collectors.toList());
        return list.get(list.size() - 1);
    }

    /**
     * Return sorted students list.
     * If two students have the same count of marks, then students should be ordered by surname
     *
     * @param students students stream
     * @return
     */
    public List<Student> sortStudentsByCountOfMarks(Stream<Student> students) {
        List<Student> list = students.sorted(Comparator.comparing(student -> {
            return student.getSubjectMarks().stream().map(SubjectMark::getMark).count();
        }))
                .collect(Collectors.toList());
        Collections.reverse(list);
        return list;
    }

    /**
     * Should return IDs of subjects sorted by academic performance in ascending order.
     *
     * @param students students stream
     * @return
     */
    public List<Integer> getSubjectsByAcademicPerformance(Stream<Student> students) {
        Map<Integer, Integer> map = students.flatMap(student -> student.getSubjectMarks().stream())
                .collect(Collectors.groupingBy(SubjectMark::getSubjectId, Collectors.summingInt(SubjectMark::getMark)));
        List<Integer> list = new ArrayList<>();
        map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue())
                .forEach((k) -> {list.add(k.getKey());});
        return list;
    }

    /**
     * Should return the subject that most teachers lead.
     * If two or more subject lead the same count of teacher, then return any of this subjects.
     *
     * @param teachers not empty teachers stream
     * @return
     */
    public Subject getSubjectThatMostTeachersLead(Stream<Teacher> teachers) {
        List<Map.Entry<Subject, Long>> list = teachers.flatMap(teacher -> teacher.getTaughtSubjects().stream())
                .collect(Collectors.groupingBy(subject -> subject, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<Subject, Long>comparingByValue())
                .collect(Collectors.toList());
        return list.get(list.size() - 1).getKey();
    }

    /**
     * Should sort excellent students by surname.
     * A student is considered an excellent student if his average mark is at least 8.
     * A student is considered a graduate if his age is not less than 21.
     *
     * @param students students stream
     * @return
     */
    public List<Student> getGraduatedExcellentStudents(Stream<Student> students) {
        return students.filter(student -> {
            return student.getSubjectMarks().stream().collect(Collectors.averagingDouble(SubjectMark::getMark)) >= 8
                    && LocalDate.now().getYear() - student.getBirthday().getYear() >= 21;
        }).collect(Collectors.toList());
    }

    /**
     * Should return the head of the a department whose students have the highest average mark.
     * If students from two or more departments have the same average mark, then return any head of this departments.
     *
     * @param departments not empty departments stream
     * @return
     */
    public Teacher getHeadOfTheMostSuccessfulDepartment(Stream<Department> departments) {
        List<Department> list = departments.sorted(Comparator.comparing(department -> {
            return department.getStudents().stream()
                    .flatMap(student -> student.getSubjectMarks().stream())
                    .collect(Collectors.averagingInt(SubjectMark::getMark));
        })).collect(Collectors.toList());
        return list.get(list.size() - 1).getHead();
    }

    /**
     * Should return subjects list that head teaches in his department.
     *
     * @param department find corresponding subjects for this department
     * @return
     */
    public List<Subject> getSubjectsThatHeadTeachesInHisDepartment(Department department) {
        Set<Subject> set1 = department.getHead().getTaughtSubjects();
        Set<Subject> set2 = department.getSubjects();
        return set1.stream().filter(s -> set2.contains(s)).collect(Collectors.toList());
    }
}
