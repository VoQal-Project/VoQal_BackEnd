package Capstone.VoQal.global.auth.service;


import Capstone.VoQal.domain.member.domain.Member;
import Capstone.VoQal.domain.member.repository.Member.MemberRepository;
import Capstone.VoQal.global.auth.dto.*;
import Capstone.VoQal.global.enums.ErrorCode;
import Capstone.VoQal.global.enums.Role;
import Capstone.VoQal.global.error.exception.BusinessException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import static Capstone.VoQal.global.enums.Role.GUEST;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO) {
        Optional<Member> findEmail = memberRepository.findByEmail(signUpRequestDTO.getEmail());
        if (findEmail.isPresent()) {
            throw new BusinessException(ErrorCode.MEMBER_PROFILE_DUPLICATION);
        }
        Role role = GUEST;

        String hashedPassword = passwordEncoder.encode(signUpRequestDTO.getPassword());
        Member member = Member.builder()
                .name(signUpRequestDTO.getName())
                .email(signUpRequestDTO.getEmail())
                .phoneNumber(signUpRequestDTO.getPhoneNum())
                .nickName(signUpRequestDTO.getNickName())
                .password(hashedPassword)
                .build();
        member.setRole(role);

        memberRepository.save(member);
        return SignUpResponseDTO.builder()
                .name(member.getName())
                .email(member.getEmail())
                .phoneNum(member.getPhoneNumber())
                .nickName(member.getNickName())
                .build();
    }



    @Transactional
    public GeneratedTokenDTO login(LoginRequestDTO loginRequestDTO) {
        Optional<Member> findEmail = memberRepository.findByEmail(loginRequestDTO.getEmail());

        if (findEmail.isPresent()) {
            Member member = findEmail.get();
            if (passwordEncoder.matches(loginRequestDTO.getPassword(), member.getPassword())) {
                SecurityMemberDTO securityMemberDTO = SecurityMemberDTO.builder()
                        .id(member.getId())
                        .email(member.getEmail())
                        .role(member.getRole())
                        .name(member.getName())
                        .phoneNum(member.getPhoneNumber())
                        .nickName(member.getNickName())
                        .build();

                GeneratedTokenDTO generatedTokenDTO = jwtProvider.generateTokens(securityMemberDTO);

                return generatedTokenDTO;
            } else {
                throw new BusinessException(ErrorCode.INVALID_PASSWORD);
            }

        } else {
            throw new BusinessException(ErrorCode.INVALID_INPUT_VALUE);
        }
    }

    @Transactional
    public boolean dupliacteNickname(String requestNickname) {
        Optional<Member> findNickname = memberRepository.findByNickName(requestNickname);
        return findNickname.isPresent();

    }
    @Transactional
    public boolean duplicateEmail(String requsetEmail) {
        Optional<Member> findEmail = memberRepository.findByEmail(requsetEmail);

        return findEmail.isPresent();

    }

    @Transactional
    public FindEmailResponseDTO findEmail(String name, String phoneNumber) {
        Optional<Member> findMember = memberRepository.findByNameAndPhoneNumber(name, phoneNumber);

        if (findMember.isPresent()) {
            Member findEmailMember = findMember.get();
            return FindEmailResponseDTO.builder()
                    .email(findEmailMember.getEmail())
                    .build();
        }
        else {
            throw new BusinessException(ErrorCode.MEMBER_NOT_FOUND);
        }

    }

    @Transactional
    public boolean checkMember(FindRequestDTO.Password findPasswordRequestDTO) {
        Optional<Member> findMember = memberRepository.findByNameAndPhoneNumberAndEmail(findPasswordRequestDTO.getName(),findPasswordRequestDTO.getPhoneNumber(),findPasswordRequestDTO.getEmail());

        return findMember.isPresent();
    }

    @Transactional
    public void resetPassword(FindRequestDTO.ResetPassword passwordRequestDTO) {
        Optional<Member> findEmail = memberRepository.findByEmail(passwordRequestDTO.getEmail());

        findEmail.ifPresent(member -> {
            String hashedPassword = passwordEncoder.encode(passwordRequestDTO.getPassword());
            member.changePassword(hashedPassword);
            memberRepository.save(member);
        });
        if (findEmail.isEmpty()) {
            throw new BusinessException(ErrorCode.MEMBER_NOT_FOUND);
        }
    }


}



