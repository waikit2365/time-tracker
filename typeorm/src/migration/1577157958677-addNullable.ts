import {MigrationInterface, QueryRunner} from "typeorm";

export class addNullable1577157958677 implements MigrationInterface {
    name = 'addNullable1577157958677'

    public async up(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "schedule" ALTER COLUMN "created_at" datetime`, undefined);
        await queryRunner.query(`ALTER TABLE "schedule" ALTER COLUMN "modify_at" datetime`, undefined);
    }

    public async down(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "schedule" ALTER COLUMN "modify_at" datetime NOT NULL`, undefined);
        await queryRunner.query(`ALTER TABLE "schedule" ALTER COLUMN "created_at" datetime NOT NULL`, undefined);
    }

}
