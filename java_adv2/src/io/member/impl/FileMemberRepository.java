package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.*;

public class FileMemberRepository implements MemberRepository {

    public static final String FILE_PATH = "temp/members-txt.dat";
    public static final String DELIMITER = ",";

    @Override
    public void add(Member member) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, UTF_8, true))) {
            writer.write(member.getId() + DELIMITER + member.getName() + DELIMITER + member.getAge());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH, UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] memberData = line.split(DELIMITER);
                members.add(new Member(memberData[0], memberData[1], Integer.valueOf(memberData[2])));
            }
            return members;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
