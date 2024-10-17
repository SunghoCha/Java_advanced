package io.member.impl;

import io.member.Member;
import io.member.MemberConst;
import io.member.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static io.member.MemberConst.*;

public class ObjectMemberRepository implements MemberRepository {

    @Override
    public void add(Member member) {
        List<Member> members = findAll();
        members.add(member);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH_OBJ))) {
            oos.writeObject(members);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Member> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH_OBJ))) {
            Object findObject = ois.readObject();
            return (List<Member>) findObject;
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // 보통 불변인 List.of()을 사용하지만 이렇게하면 add()에서 처음 빈 배열을 받고 데이터 추가 불가능(일관성을 위해 다른 repository도 이렇게 구현)
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }
}
