package mx.edu.utez.sigede_backend.models.verification_code;

import mx.edu.utez.sigede_backend.models.user_account.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Long> {
    VerificationCode findByFkUserAccount(UserAccount fkUserAccount);
    void deleteByFkUserAccount(UserAccount fkUserAccount);
}
